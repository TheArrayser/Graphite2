package me.eglp.gv2.util.emote;

import java.util.Arrays;

import me.eglp.amongus4graphite.auc.PlayerColor;
import me.eglp.gv2.main.Graphite;
import net.dv8tion.jda.api.entities.emoji.Emoji;

public enum JDAEmote {

	ONE_HUNDRED("\uD83D\uDCAF"),
	OK("\uD83C\uDD97"),
	ARROW_LEFT("\u2B05"),
	ARROW_RIGHT("\u27A1"),
	ARROW_UP("\u2B06"),
	ARROW_DOWN("\u2B07"),
	X("\u274C"),
	O("\u2B55"),
	OK_HAND("\uD83D\uDC4C"),
	ZERO("0\u20E3"),
	ONE("1\u20E3"),
	TWO("2\u20E3"),
	THREE("3\u20E3"),
	FOUR("4\u20E3"),
	FIVE("5\u20E3"),
	SIX("6\u20E3"),
	SEVEN("7\u20E3"),
	EIGHT("8\u20E3"),
	NINE("9\u20E3"),
	TEN("\uD83D\uDD1F"),
	ELEVEN(629973633976107012L),
	TWELVE(629973633883832321L),
	THIRTEEN(629973634471165952L),
	FOURTEEN(629973634089222144L),
	FIFTEEN(629973634202599424L),
	SIXTEEN(1009857567788372128L),
	SEVENTEEN(1009857566215520266L),
	EIGHTEEN(1009857564776861768L),
	NINETEEN(1009857563409534976L),
	TWENTY(1009857561677283328L),
	ASTERISK("*\u20E3"),
	BLACK_LARGE_SQUARE("\u2B1B"),
	WHITE_LARGE_SQUARE("\u2B1C"),
	GREEN_SQUARE("\uD83D\uDFE9"),
	BOOM("\uD83D\uDCA5"),
	TRIANGULAR_FLAG_ON_POST("\uD83D\uDEA9"),
	BOMB("\uD83D\uDCA3"),
	TRACK_PREVIOUS("\u23EE"),
	REPEAT("\uD83D\uDD01"),
	REPEAT_ONE("\uD83D\uDD02"),
	RED_CIRCLE("\uD83D\uDD34"),
	WHITE_CIRCLE("\u26AA"),
	LARGE_BLUE_CIRCLE("\uD83D\uDD35"),
	BLACK_CIRCLE("\u26AB"),
	QUESTION("\u2753"),
	WHITE_CHECK_MARK("\u2705"),
	NEGATIVE_SQUARED_CROSS_MARK("\u274E"),
	CLOCK1("\uD83D\uDD50"),
	OCEAN("\uD83C\uDF0A"),
	EXCLAMATION("\u2757"),
	PALM_TREE("\uD83C\uDF34"),
	DECIDUOUS_TREE("\uD83C\uDF33"),
	EVERGREEN_TREE("\uD83C\uDF32"),
	SMALL_ORANGE_DIAMOND("\uD83D\uDD38"),
	GREY_EXCLAMATION("\u2755"),
	MOUNT_FUJI("\uD83D\uDDFB"),
	MOUNTAIN_SNOW("\uD83C\uDFD4"),
	MOUNTAIN("\u26F0"),
	BEACH("\uD83C\uDFD6"),
	BEACH_UMBRELLA("\u26F1"),
	DESERT("\uD83C\uDFDC"),
	HOMES("\uD83C\uDFD8"),
	CHART_WITH_UPWARDS_TREND("\uD83D\uDCC8"),
	GRAPHITE(852285616029040650L),
	DOLLARONEN(629972458232872961L),
	INFO(630110548058570819L),
	CARD_CLOVER(726766524546809916L),
	CARD_SPADE(726766524529901638L),
	CARD_HEART(726766524366454795L),
	CARD_TILE(726766524559261706L),
	CARD_RED_ACE(726766524483764254L),
	CARD_BLACK_ACE(726766524471312434L),
	CARD_RED_TWO(726766523145781289L),
	CARD_BLACK_TWO(726766522881540179L),
	CARD_RED_THREE(726766523552628817L),
	CARD_BLACK_THREE(726766523552891001L),
	CARD_RED_FOUR(726766523661942884L),
	CARD_BLACK_FOUR(726766523745566720L),
	CARD_RED_FIVE(726766523451965541L),
	CARD_BLACK_FIVE(726766523368341515L),
	CARD_RED_SIX(726766524496478258L),
	CARD_BLACK_SIX(726766523699560469L),
	CARD_RED_SEVEN(726766524102082643L),
	CARD_BLACK_SEVEN(726766524454535218L),
	CARD_RED_EIGHT(726766524525969428L),
	CARD_BLACK_EIGHT(726766524530032690L),
	CARD_RED_NINE(726766524513386516L),
	CARD_BLACK_NINE(726766524139962439L),
	CARD_RED_TEN(726766524253208627L),
	CARD_BLACK_TEN(726766524244819969L),
	CARD_RED_JACK(726766524471181343L),
	CARD_BLACK_JACK(726766524454535229L),
	CARD_RED_QUEEN(726766524395683991L),
	CARD_BLACK_QUEEN(726766524500672582L),
	CARD_RED_KING(726766524165128224L),
	CARD_BLACK_KING(726766524391620649L),
	CARD_BACK_TOP(726795131180679208L),
	CARD_BACK_BOTTOM(726795131491188806L),
	LEFT_RIGHT_ARROW("\u2194\uFE0F"),
	DICE_ONE(736863376483024927L),
	DICE_TWO(736863376889872484L),
	DICE_THREE(736863376885678120L),
	DICE_FOUR(736863376902193153L),
	DICE_FIVE(736863377158045746L),
	DICE_SIX(736863377283874837L),
	COINFLIP_HEADS(847764930710470656L),
	COINFLIP_TAILS(847764930827518003L),
	BRICKS("\uD83E\uDDF1"),
	ROLL_OF_PAPER("\uD83E\uDDFB"),
	SCISSORS("\u2702\uFE0F"),
	PAUSE("\u23F8\uFE0F"),
	HAND_SPLAYED("\uD83D\uDD90\uFE0F"),
	ERROR(828351185978261515L),
//	HIT(730460124589588561L),
//	STAND(730460306626838579L),
	WASTEBASKET("\uD83D\uDDD1\uFE0F"),
	POKER_CHIP_1(739177198224670840L),
	POKER_CHIP_5(739177198828912702L),
	POKER_CHIP_10(739177201425186868L),
	POKER_CHIP_20(739177202222104596L),
	POKER_CHIP_25(739177201638965279L),
	POKER_CHIP_100(739177201739759698L),
	POKER_CHIP_500(739177202041618453L),
	POKER_FOLD(739203822429143192L),
	POKER_CHECK(739203822479474838L),
	POKER_BET(739203822144192553L),
	POKER_ALL_IN(739454761291743311L),
	POKER_DEALER(739477555958120449L),
	EYES("\uD83D\uDC40"),
	BLACK_ONE(740948468981563403L),
	BLACK_TWO(740951147799642202L),
	BLACK_THREE(740951147543789629L),
	BLACK_FOUR(740951147824545863L),
	BLACK_FIVE(740951147959025694L),
	BLACK_SIX(740951415601758219L),
	GEAR("\u2699\uFE0F"),
	CLOSED_LOCK_WITH_KEY("\uD83D\uDD10"),
	LOCK_WITH_INK_PEN("\uD83D\uDD0F"),
	PEN_FOUNTAIN("\uD83D\uDD8B\uFE0F"),
	NO_ENTRY_SIGN("\uD83D\uDEAB"),
	ENVELOPE("\u2709\uFE0F"),
	ENVELOPE_WITH_ARROW("\uD83D\uDCE9"),
	HASH("#\uFE0F\u20E3"),
	INBOX_TRAY("\uD83D\uDCE5"),
	BUSTS_IN_SILHOUETTE("\uD83D\uDC65"),
	TOOLS("\uD83D\uDEE0uFE0F"),
	ROBOT("\uD83E\uDD16"),
	SCROLL("\uD83D\uDCDC"),
	SHIELD("\uD83D\uDEE1\uFE0F"),
	CLOUD("\u2601\uFE0F"),
	PENCIL("\uD83D\uDCDD"),
	PENCIL2("\u270F\uFE0F"),
	PARK("\uD83C\uDFDE\uFE0F"),
	WAVE("\uD83D\uDC4B"),
	HEAVY_CHECK_MARK("\u2714\uFE0F"),
	AMONG_US_RED(862072110834384916L),
	AMONG_US_BLUE(862072109454065694L),
	AMONG_US_GREEN(862072110431993876L),
	AMONG_US_PINK(862072110737653760L),
	AMONG_US_ORANGE(862072110331330571L),
	AMONG_US_YELLOW(862072111022211085L),
	AMONG_US_BLACK(862072109051543592L),
	AMONG_US_WHITE(862072111026798622L),
	AMONG_US_PURPLE(862072110776451072L),
	AMONG_US_BROWN(862072109709525052L),
	AMONG_US_CYAN(862072110104838174L),
	AMONG_US_LIME(862072110574075904L),
	AMONG_US_MAROON(862072110523744266L),
	AMONG_US_ROSE(862072110549565451L),
	AMONG_US_BANANA(862072108497633290L),
	AMONG_US_GRAY(862072110133280828L),
	AMONG_US_TAN(862072110721400893L),
	AMONG_US_CORAL(862072109546602507L),
	AMONG_US_RED_DEAD(879734494461050982L),
	AMONG_US_BLUE_DEAD(879734634303332374L),
	AMONG_US_GREEN_DEAD(879734710492860457L),
	AMONG_US_PINK_DEAD(879734738858950666L),
	AMONG_US_ORANGE_DEAD(879734802864029708L),
	AMONG_US_YELLOW_DEAD(879734854474932234L),
	AMONG_US_BLACK_DEAD(879734893637140481L),
	AMONG_US_WHITE_DEAD(879734932803584000L),
	AMONG_US_PURPLE_DEAD(879735979752165396L),
	AMONG_US_BROWN_DEAD(879735850265636885L),
	AMONG_US_CYAN_DEAD(879735883409010688L),
	AMONG_US_LIME_DEAD(879735912123219998L),
	AMONG_US_MAROON_DEAD(879733085636263946L),
	AMONG_US_ROSE_DEAD(879733167425220619L),
	AMONG_US_BANANA_DEAD(879733282663706675L),
	AMONG_US_GRAY_DEAD(879733302850904065L),
	AMONG_US_TAN_DEAD(879733318378221568L),
	AMONG_US_CORAL_DEAD(879733333263790151L),
	TRANSPARENT(911252622919487520L),
	MEGA("\uD83D\uDCE3"),
	LOUD_SOUND("\uD83D\uDD0A"),
	MICROPHONE("\uD83C\uDFA4"),
	;
	
	private static final JDAEmote[] KEYCAP_NUMS = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, NINETEEN, TWENTY};
	private static final JDAEmote[] BLACK_KEYCAP_NUMS = {null, BLACK_ONE, BLACK_TWO, BLACK_THREE, BLACK_FOUR, BLACK_FIVE, BLACK_SIX};
	private static final JDAEmote[] DICE_NUMS = {DICE_ONE, DICE_TWO, DICE_THREE, DICE_FOUR, DICE_FIVE, DICE_SIX};
	
	private Emoji emoji;
	private long id; // Used for lazy loading of custom emoji
	
	private JDAEmote(String unicode) {
		this.emoji = Emoji.fromUnicode(unicode);
	}
	
	private JDAEmote(long discordId) {
		this.id =  discordId;
	}
	
	private void load() {
		if(emoji != null) return;
		this.emoji = Graphite.getGlobalJDAEmote(id);
	}
	
	public String getEncoded() {
		load();
		return emoji.getFormatted();
	}
	
	public String getUnicode() {
		load();
		return emoji.getFormatted();
	}
	
	public Emoji getEmoji() {
		load();
		return emoji;
	}
	
	public boolean equalsEmoji(Emoji e) {
		return emoji.equals(e);
	}
	
	public static JDAEmote getKeycapNumber(int num) {
		if(num < 0 || num >= KEYCAP_NUMS.length) return null;
		return KEYCAP_NUMS[num];
	}
	
	public static JDAEmote getBlackKeycapNumber(int num) {
		if(num < 0 || num >= BLACK_KEYCAP_NUMS.length) return null;
		return BLACK_KEYCAP_NUMS[num];
	}
	
	public static JDAEmote getDiceNumber(int num) {
		if(num < 1 || num > DICE_NUMS.length) return null;
		return DICE_NUMS[num - 1];
	}
	
	public static JDAEmote getByEmoji(Emoji emoji) {
		return Arrays.stream(values()).filter(e -> e.emoji.equals(emoji)).findFirst().orElse(null);
	}

	public static JDAEmote getById(long id) {
		return Arrays.stream(values()).filter(e -> e.id != 0 && e.id == id).findFirst().orElse(null);
	}
	
	public static JDAEmote getCrewmateEmote(PlayerColor color) {
		return valueOf("AMONG_US_" + color.name());
	}
	
	public static JDAEmote getDeadCrewmateEmote(PlayerColor color) {
		return valueOf("AMONG_US_" + color.name() + "_DEAD");
	}
	
}
