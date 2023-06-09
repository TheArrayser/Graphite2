package me.eglp.gv2.util.webinterface.handlers;

import java.util.List;
import java.util.stream.Collectors;

import me.eglp.gv2.multiplex.GraphiteFeature;
import me.eglp.gv2.util.base.guild.GraphiteGuild;
import me.eglp.gv2.util.base.guild.config.GuildPollsConfig;
import me.eglp.gv2.util.base.guild.poll.GuildPoll;
import me.eglp.gv2.util.webinterface.WebinterfaceHandler;
import me.eglp.gv2.util.webinterface.base.WebinterfaceRequestEvent;
import me.eglp.gv2.util.webinterface.base.WebinterfaceResponse;
import me.mrletsplay.mrcore.json.JSONArray;
import me.mrletsplay.mrcore.json.JSONObject;

public class PollRequestHandler {
	
	@WebinterfaceHandler(requestMethod = "getPolls", requireGuild = true, requireFeatures = GraphiteFeature.FUN)
	public static WebinterfaceResponse getReports(WebinterfaceRequestEvent event) {
		GraphiteGuild g = event.getSelectedGuild();
		GuildPollsConfig c = g.getPollsConfig();
		List<GuildPoll> polls = c.getPolls();
		JSONObject o = new JSONObject();
		o.put("polls", new JSONArray(polls.stream().map(p -> p.toWebinterfaceObject()).collect(Collectors.toList())));
		return WebinterfaceResponse.success(o);
	}
	
	@WebinterfaceHandler(requestMethod = "finishPoll", requireGuild = true, requireFeatures = GraphiteFeature.FUN)
	public static WebinterfaceResponse finishPoll(WebinterfaceRequestEvent event) {
		GraphiteGuild g = event.getSelectedGuild();
		GuildPollsConfig c = g.getPollsConfig();
		String pollID = event.getRequestData().getString("id");
		if(c.getPoll(pollID) == null) {
			return WebinterfaceResponse.error("Poll doesn't exist");
		}
		c.getPoll(pollID).finish();
		return WebinterfaceResponse.success();
	}

}
