package me.eglp.gv2.commands.moderation;

import java.util.Arrays;
import java.util.List;

import me.eglp.gv2.util.base.guild.GraphiteGuild;
import me.eglp.gv2.util.base.guild.GraphiteMember;
import me.eglp.gv2.util.base.guild.GraphiteModule;
import me.eglp.gv2.util.base.guild.config.GuildModerationConfig;
import me.eglp.gv2.util.base.user.GraphiteUser;
import me.eglp.gv2.util.command.CommandCategory;
import me.eglp.gv2.util.command.CommandInvokedEvent;
import me.eglp.gv2.util.command.Command;
import me.eglp.gv2.util.lang.DefaultLocaleString;
import me.eglp.gv2.util.lang.DefaultMessage;
import me.eglp.gv2.util.lang.GraphiteTimeParser;
import me.eglp.gv2.util.lang.LocalizedTimeUnit;
import me.eglp.gv2.util.permission.DefaultPermissions;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class CommandTempChatMute extends Command{
	
	public CommandTempChatMute() {
		super(GraphiteModule.MODERATION, CommandCategory.MODERATION, "tempchatmute");
		addAlias("tcmute");
		setDescription(DefaultLocaleString.COMMAND_TEMPCHATMUTE_DESCRIPTION);
		setUsage(DefaultLocaleString.COMMAND_TEMPCHATMUTE_USAGE);
		setPermission(DefaultPermissions.MODERATION_TEMPCHATMUTE);
		requirePermissions(Permission.MANAGE_ROLES);
	}
	
	@Override
	public void action(CommandInvokedEvent event) {
		GraphiteGuild g = event.getGuild();
		GraphiteUser user = (GraphiteUser) event.getOption("user");
		GraphiteMember mem = g.getMember(user);
		if(mem == null) {
			DefaultMessage.ERROR_NOT_A_MEMBER.reply(event);
			return;
		}
		
		if(mem.isBot()) {
			DefaultMessage.ERROR_IS_BOT.reply(event);
			return;
		}
		
		if(!g.getSelfMember().canInteract(mem)) {
			DefaultMessage.ERROR_CANT_INTERACT_MEMBER.reply(event);
			return;
		}
		
		GuildModerationConfig c = g.getModerationConfig();
		if(c.isChatMuted(mem)) {
			DefaultMessage.ERROR_ALREADY_MUTED.reply(event);
			return;
		}
		
		long duration = GraphiteTimeParser.parseShortDuration((String) event.getOption("duration"));
		if(duration == -1) {
			DefaultMessage.ERROR_INVALID_DURATION.reply(event);
			return;
		}
		
		if(duration < 1000 * 60) {
			DefaultMessage.ERROR_MINIMUM_TEMP_DURATION.reply(event);
			return;
		}
		
		String r = (String) event.getOption("reason");
		c.createTempChatMute(mem, duration, event.getMember(), r);
		
		DefaultMessage.COMMAND_TEMPCHATMUTE_SUCCESS.reply(event, 
				"user", user.getName(), 
				"duration", LocalizedTimeUnit.formatTime(g, duration),
				"reason", r == null ? "No reason" : r);
	}

	@Override
	public List<OptionData> getOptions() {
		return Arrays.asList(
				new OptionData(OptionType.USER, "user", "The user you want to temporarily chatmute", true),
				new OptionData(OptionType.STRING, "duration", "How long you want to temporarily chatmute the user", true),
				new OptionData(OptionType.STRING, "reason", "A short reason why you want to temporarily chatmute this user", false)
			);
	}

}
