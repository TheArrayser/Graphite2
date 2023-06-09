package me.eglp.gv2.commands.fun;

import java.awt.Color;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import me.eglp.gv2.util.base.guild.GraphiteGuildMessageChannel;
import me.eglp.gv2.util.base.guild.GraphiteModule;
import me.eglp.gv2.util.base.guild.reminder.GuildReminder;
import me.eglp.gv2.util.base.guild.reminder.A5316ec6481b84f9eac9f0968b00e06ba;
import me.eglp.gv2.util.command.Command;
import me.eglp.gv2.util.command.CommandCategory;
import me.eglp.gv2.util.command.CommandInvokedEvent;
import me.eglp.gv2.util.command.ParentCommand;
import me.eglp.gv2.util.lang.DefaultLocaleString;
import me.eglp.gv2.util.lang.DefaultMessage;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

/**
 * This is the reminder Command class. It handles the different sub-commands and
 * deligates the functionality to {@link GuildReminder}.
 * 
 * @author The Arrayser
 * @date Mon Mar 27 18:28:48 2023
 */

public class CommandReminder extends ParentCommand {

	public CommandReminder() {
		super(GraphiteModule.FUN, CommandCategory.FUN, "reminder");
		setDescription(DefaultLocaleString.COMMAND_REMINDER_DESCRIPTION);

		addSubCommand(new Command(this, "create") {

			@Override
			public void action(CommandInvokedEvent event) {
				// The structure of the command is as follows, where prefix is either a slash or the per-guild prefix: "{prefix}reminder create <date and time> <reminder message> [repeat (1y2d)] [channel]"
				String date = (String) event.getOption("date_and_time");
				String reminderMessage = (String) event.getOption("reminder_message");

				// optional
				String repeat = (String) event.getOption("repeat");
				A5316ec6481b84f9eac9f0968b00e06ba repeatE;
				
				if (repeat == null) {
					repeatE = null;
				} else {
					repeatE = A5316ec6481b84f9eac9f0968b00e06ba.valueOf(repeat);
				}
				
				GraphiteGuildMessageChannel channel = (GraphiteGuildMessageChannel) event.getOption("channel");
				if (channel == null) {
					// Use the current channel instead
					channel = event.getGuildChannel();
				}

				LocalDateTime dateMs = null;

				try {
					dateMs = LocalDateTime.parse(date, GuildReminder.HUMAN_TIMESTAMP_FORMAT);
				} catch (DateTimeParseException e) {
					DefaultMessage.ERROR_INVALID_TIMESTAMP.reply(event);
					return;
				}

				if (dateMs.atZone(event.getGuild().getConfig().getTimezone()).toEpochSecond() <= System.currentTimeMillis() / 1000) {
					DefaultMessage.COMMAND_REMINDER_CREATE_EVENT_IS_IN_THE_PAST.reply(event);
					return;
				}
				
				
				
				GuildReminder reminder = new GuildReminder(event.getGuild(), dateMs, reminderMessage, repeatE, channel);
				

				reminder.enqueue();
				event.getGuild().getRemindersConfig().saveReminder(reminder);
				
				// In the case that everything worked according to plan, the following line will print the message "Your reminder got succesefully enqueued!"
				DefaultMessage.COMMAND_REMINDER_CREATE_SUCCESS.reply(event);
			}

			@Override
			public List<OptionData> getOptions() {
				OptionData optionRepeat = new OptionData(OptionType.STRING, "repeat",
						"Whether and when to repeat the reminder", false);
				for (A5316ec6481b84f9eac9f0968b00e06ba a : A5316ec6481b84f9eac9f0968b00e06ba.values()) {
					optionRepeat.addChoice(a.toString(), a.name());
				}
				List<OptionData> ops = new ArrayList<>(Arrays.asList(new OptionData(OptionType.STRING, "date_and_time", "When the reminder is triggered", true), new OptionData(OptionType.STRING, "reminder_message", "The message of the reminder", true), optionRepeat, new OptionData(OptionType.CHANNEL, "channel", "The channel in which to send the reminder", false).setChannelTypes(ChannelType.TEXT, ChannelType.NEWS, ChannelType.GUILD_NEWS_THREAD, ChannelType.GUILD_PRIVATE_THREAD, ChannelType.GUILD_PUBLIC_THREAD)));
				return ops;
			}
		}).setDescription(DefaultLocaleString.COMMAND_REMINDER_CREATE_DESCRIPTION) .setUsage(DefaultLocaleString.COMMAND_REMINDER_CREATE_USAGE).setPermission("fun.reminder.create");

		addSubCommand(new Command(this, "list") {

			@Override
			public void action(CommandInvokedEvent event) {
				List<GuildReminder> reminders = event.getGuild().getRemindersConfig().getReminders();
				if (reminders.isEmpty()) {
					DefaultMessage.COMMAND_REMINDER_LIST_NO_REMINDERS.reply(event);
					return;
				}

				EmbedBuilder theEmbed = new EmbedBuilder().setColor(Color.PINK)
						.setDescription(DefaultLocaleString.COMMAND_REMINDER_LIST_EMBED_DESCRIPTION.getFor(event.getGuild()))
						.setTitle(DefaultLocaleString.COMMAND_REMINDER_LIST_EMBED_TITLE.getFor(event.getGuild()));
				
				Map<String, List<GuildReminder>> remindersPerChannel = new LinkedHashMap<>();
				
				for (GuildReminder currentReminder : reminders) {
					List<GuildReminder> a = remindersPerChannel.get(currentReminder.getChannelID());
					if(a == null) {
						a = new ArrayList<>();
					}
					a.add(currentReminder);
					remindersPerChannel.put(currentReminder.getChannelID(), a);
					
					// what is the following line for?
					//currentReminder.getChannelID() 
				}
				
				for(Map.Entry<String, List<GuildReminder>> e : remindersPerChannel.entrySet()) {
					String messageList = new String();
					for(GuildReminder q : e.getValue()) {
						messageList = messageList.concat(q.getId() + ": " + q.getMessage() +"\n");
					}
					
					String messageChannelName = event.getGuild().getGuildMessageChannelByID(e.getKey()).getName();
					
					theEmbed.addField(messageChannelName, messageList, true);
				}
				
				event.reply(theEmbed.build());
			}

			@Override
			public List<OptionData> getOptions() {
				return Collections.emptyList();
			}
		}).setDescription(DefaultLocaleString.COMMAND_REMINDER_LIST_DESCRIPTION)
				.setUsage(DefaultLocaleString.COMMAND_REMINDER_LIST_USAGE).setPermission("fun.reminder.list");

		addSubCommand(new Command(this, "remove") {

			@Override
			public void action(CommandInvokedEvent event) {
				String reminderID = (String) event.getOption("reminder");
				GuildReminder reminder = event.getGuild().getRemindersConfig().getReminder(reminderID);
				if (reminder == null) {
					DefaultMessage.COMMAND_REMINDER_REMOVE_INVALID_REMINDER.reply(event);
					return;
				}

				reminder.remove();
				DefaultMessage.COMMAND_REMINDER_REMOVE_SUCCESS.reply(event);
			}

			@Override
			public List<OptionData> getOptions() {
				return Arrays.asList(new OptionData(OptionType.STRING, "reminder", "The ID of the reminder", true));
			}
		}).setDescription(DefaultLocaleString.COMMAND_REMINDER_REMOVE_DESCRIPTION)
				.setUsage(DefaultLocaleString.COMMAND_REMINDER_REMOVE_USAGE).setPermission("fun.reminder.remove");
	}

}
