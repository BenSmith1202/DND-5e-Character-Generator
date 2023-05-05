import java.text.MessageFormat;
import java.util.Random;

public class RandomBackgroundGenerator {
    private static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    private static final String[] backgrounds = new String[]{ //Backgrounds from http://dnd5e.wikidot.com
            "Common Backgrounds",
            "Setting Specific",
            "Acolyte",
            "Anthropologist",
            "Archaeologist",
            "Athlete",
            "Charlatan",
            "City Watch",
            "Clan Crafter",
            "Cloistered Scholar",
            "Courtier",
            "Criminal",
            "Entertainer",
            "Faceless",
            "Faction Agent",
            "Far Traveler",
            "Feylost",
            "Fisher",
            "Folk Hero",
            "Gladiator",
            "Guild Artisan",
            "Guild Merchant",
            "Haunted One",
            "Hermit",
            "House Agent",
            "Inheritor",
            "Investigator",
            "Knight",
            "Knight of the Order",
            "Marine",
            "Mercenary Veteran",
            "Noble",
            "Outlander",
            "Pirate",
            "Sage",
            "Sailor",
            "Shipwright",
            "Smuggler",
            "Soldier",
            "Spy",
            "Urban Bounty Hunter",
            "Urchin",
            "Caravan Specialist",
            "Harborfolk",
            "Gate Urchin",
            "Secret Identity",
            "Shade Fanatic",
            "Trade Sheriff",
            "Gate Warden",
            "Mage of High Sorcery",
            "Rune Carver",
            "Failed Merchant",
            "Gambler",
            "Plaintiff",
            "Rival Intern",
            "Dissenter",
            "Initiate",
            "Vizier",
            "Archival Assistant",
    };


    private static String location1;
    private static String location2;

    private static final String[] adjective1 = new String[]{
            "fun", "hard", "exciting", "interesting", "unusual", "incredible", "a thoroughly wet experience", "not a walk in the park", "extraordinarily difficult", "a slog", "terrible",
            "not worth it", "confusing", "infuriating", "stellar", "violent", "unexplained but fortuitous", "cruel", "great and perhaps disatrous", "a black tie event",
            "full of egg-related puns", "complex", "unpleasant and improbable", "ineffable", "mundane", "joyful", "reasonably dull", "academic",
            "marinated in astronomical boredom", "perfect", "statistically unlikely", "agreeable", "like a divine practical joke"
    };
    private static final String[] wasInSituation = new String[]{
            "had two loving parents", "had two dead parents", "had two creatures for parents", "only had one friend, a stray dog", "was born with a missing limb",
            "had a knack for getting myself in trouble", "failed out of every school I went to", "was born of noble blood", "had a pet moose", "couldn't handle a moose",
            "had a love for fine art", "had a large group of friends", "was hit by a runaway carriage", "wanted nothing more that to see the ocean", "had an unknown medical condition",
            "spent years studying physics", "spent years studying religion", "spent years studying mud", "spent my childhood in prison", "was taken from my birth parents"

    };
    private static final String[] somethingHappenedToMe = new String[]{
            "something happened to me"
    };
    private static final String[] occupationModifier = new String[]{
            "apprentice"
    };
    private static final String[] didSomethingBad = new String[]{
            "did something bad"
    };
    private static final String[] doSomethingHeroic = new String[]{
            "do something heroic"
    };
    private static final String[] creatures = new String[]{
            "creatures"
    };
    private static final String[] verbing = new String[]{
            "verbing"
    };
    private static final String[] relatives = new String[]{
            "relatives"
    };
    private static final String[] aggressiveVerbed = new String[]{
            "aggressively verbed"
    };
    private static final String[] hostileParty = new String[]{
            "hostile party"
    };
    private static final String[] randomObject = new String[]{
            "random object"
    };
    private static final String[] randomAbility = new String[]{
            "strength"
    };
    private static final String[] mysterySite = new String[]{
            "mystery site"
    };
    private static final String[] mysteryEntity = new String[]{
            "mystery entity"
    };

    public static String getBackstory(PlayerCharacter pchar) {
        location1 = RandomNameGenerator.getPlaceName();
        location2 = RandomNameGenerator.getPlaceName();
        Random rand = new Random();
        String backstory = "Error";
        String background = getRandom(backgrounds);
        String pclass = pchar.getCharacterClass();
        int introNum = rand.nextInt(4);
        switch (introNum) { //DO NOT USE APOSTROPHE OR OTHER UNESCAPED CHARACTERS
            case 0 -> backstory = MessageFormat.format("Growing up in {0} was {1}. I {2}, which meant that {3}.\n" +
                    "These circumstances led me to life as a(n) {4}, but nothing lasts forever.",
                    location1, getRandom(adjective1), getRandom(wasInSituation), getRandom(somethingHappenedToMe), background);
            case 1 -> backstory = MessageFormat.format("I was not always a(n) {0}, I grew up as a(n) {1} {2} in {3}. After I {4}, they fired me, which led to my current occupation. But being a {5} wasn't my final destiny", pclass, getRandom(occupationModifier), background, location1, getRandom(didSomethingBad), background);
            case 2 -> backstory = MessageFormat.format("They should write songs about {0}s like me. I may have started my life in {1} as a {2}, but I always dreamt I\n" +
                    "would {3} and earn the respect of everyone. Unfortunately, the gods had other plans.", pclass, location1, background, getRandom(doSomethingHeroic));
            case 3 -> backstory = MessageFormat.format("As a kid, I was raised in the wilds around {0} by {1}. I {2} most of the time, which is to say,\n" +
                    "life was {3}. Eventually, my parents and fellow {4} thought I should go be with my own kind. A kind {5}\n" +
                    "took me in to teach me to be a(n) {6} {7}.", location1, getRandom(creatures), getRandom(wasInSituation), getRandom(adjective1), getRandom(creatures), background, getRandom(occupationModifier), background);
        }
        return backstory;
    }

    //intro 1
    //Growing up in [Location1] was [Adjective1]. I [wasInSituation1], which meant that [Something happened to me].
    //These circumstances led me to life as a(n) [Background], but nothing lasts forever.

    //intro 2
    //I wasn't always a(n) [Class], I grew up as a(n) [occupation modifier][Background] in [Location1]. After I
    //[didSomethingBad], they fired me, which led to my current occupation. But being a [Background] wasn't my final destiny.

    //intro 3
    //They should write songs about [Class]s like me. I may have started my life in [Location1] as a [Background], but I always dreamt I
    //would [doSomethingHeroic] and earn the respect of everyone. Unfortunately, the gods had other plans.

    //Intro 4
    //As a kid, I was raised in the wilds around [Location1] by [Creatures]. I [WasInSituation] most of the time, which is to say,
    //life was [Adjective1]. Eventually, my parents and fellow [Creatures] thought I should go be with my own kind. A kind [Background]
    //took me in to teach me to be a(n) [occupation modifier][Background].

    //Call To Adventure 1
    //One night in [Location1], while I was [verbing] with my [relatives], we were [agressiveVerbed] by a [hostileParty]. After the tradgedy,
    //I swore to never let another person be [aggressive verbed] again, and so I took up arms as a [Class].

    //Call To Adventure two
    //Being a [Background] doesn't pay enough for my taste, so when I overheard something about high-paying job
    //while [verbing] in [Location 2], I was interested. All I needed was my trusty [Object] and my [random ability] to
    //complete the quest, make sure the [Hostile Party] was [agressiveVerbed], and claim my coin. And that, is how I became an adventurer.

    //Call To Adventure 3
    //One day, after a long night of drinking, some of my [relatives], my friend [getName] and I were exploring an abandoned
    // [mysterySite] near [Location2], but I was separated from them at some point, and found myself standing in front of a [MysteryEntity].
    //I could feel its voice stirring something within me, reminding me of my ideals and strengthening my resolve. If I
    //wanted to achieve my dreams as a [Class], I couldn't just go [verbing] around any longer. I needed to become an adventurer.

}