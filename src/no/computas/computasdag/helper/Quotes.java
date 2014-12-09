package no.computas.computasdag.helper;

import java.util.Random;

/**
 * @Author: vda
 */
public class Quotes {
    private static final String[] BTTF_QUOTES = {
            "Marty McFly: Hey, Doc, we better back up. We don't have enough road to get up to 88.\n" +
                    "Dr. Emmett Brown: Roads? Where we're going, we don't need roads.",
            "Dr. Emmett Brown: If my calculations are correct, when this baby hits 88 miles per hour... you're gonna see some serious shit.",
            "Marty McFly: Wait a minute. Wait a minute, Doc. Ah... Are you telling me that you built a time machine... out of a DeLorean?\n" +
                    "Dr. Emmett Brown: The way I see it, if you're gonna build a time machine into a car, why not do it with some *style?*",
            "George McFly: Lorraine. My density has brought me to you.\n" +
                    "Lorraine Baines: What?\n" +
                    "George McFly: Oh. What I meant to say was...\n" +
                    "Lorraine Baines: Wait a minute. Don't I know you from somewhere?\n" +
                    "George McFly: Yes. Yes. I'm George. George McFly. I'm your density. I mean, your destiny.",
            "Dr. Emmett Brown: Oh my God. They found me, I dont know how but they found me. Run for it Marty!\n" +
                    "Marty McFly: Who, who!?\n" +
                    "Dr. Emmett Brown: Who do you think!? The Libyans!",
            "Lou: You gonna order something, kid?\n" +
                    "Marty McFly: Ah, yeah. Give me- Give me a Tab.\n" +
                    "Lou: Tab? I can't give you a tab unless you order something.\n" +
                    "Marty McFly: Right. Give me a Pepsi Free.\n" +
                    "Lou: You want a Pepsi, pal, you're gonna pay for it."
    };

    public static String getRandomQuote() {
        System.out.println("getting quotes");
        return BTTF_QUOTES[new Random().nextInt(BTTF_QUOTES.length)];
    }

}
