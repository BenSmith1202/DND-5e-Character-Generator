import java.text.MessageFormat;
import java.util.Random;

/**
 * @author  Ben Smith, David Olinger
 * Generates a random dnd background story
 */
public class RandomBackgroundGenerator {
    private static String getRandom(String[] array) { //returns a random String from an array
        int index = (int)(Math.round(Math.random() * (array.length-1)));
        return array[index];

    }

    private static final String[] backgrounds = new String[]{ //Backgrounds from http://dnd5e.wikidot.com
            "Acolyte", "Anthropologist", "Archaeologist", "Athlete", "City Watchman",
            "Clan Crafter", "Cloistered Scholar", "Courtier", "Criminal", "Entertainer",
            "Faction Agent", "Far Traveler", "Fisher", "Folk Hero", "Gladiator", "Guild Artisan",
            "Guild Merchant", "Haunted One", "Hermit", "House Agent", "Investigator",
            "Knight", "Knight of the Order", "Marine", "Mercenary Veteran", "Noble",
            "Outlander", "Pirate", "Sage", "Sailor", "Shipwright", "Smuggler", "Soldier",
            "Spy", "Urban Bounty Hunter", "Caravan Specialist", "Harborfolk", "Gate Urchin", "Shade Fanatic",
            "Trade Sheriff", "Gate Warden", "Mage of High Sorcery", "Rune Carver",
            "Failed Merchant", "Gambler", "Plaintiff", "Intern", "Vizier", "Archival Assistant",
    };


    private static String location1;
    private static String location2;


    /**
     * Below are many various words that will be filled into the backstory templates to create randomness
     */
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
            "spent years studying physics", "spent years studying religion", "spent years studying mud", "spent my childhood in prison", "was taken from my birth parents", "contracted a magical illness"

    };
    private static final String[] somethingHappenedToMe = new String[]{
            "I developed a rare disease", "I caught the interest of a few less than benevolent parties", "I was invited to a lot of parties", "I felt a surge of determination coursing through me",
            "I developed an allergy to goblins", "I was deemed worthy of inheriting my family's heirloom armor", "I was able to pull a legendary weapon out of a stone",
            "I was tracked down by assassins and needed to fight my way out", "I was a natural in the ways of combat", "I was sent to a special school for kids like me"
    };
    private static final String[] occupationModifier = new String[]{
            "apprentice", "master", "journeyman", "novice", "supervisory", "terrible", "masterful", "skilled", "royal"
    };
    private static final String[] didSomethingBad = new String[]{
            "did something bad", "flirted with the wrong woman", "fell asleep when I shouldn't've", "stole a few things", "took a practical joke too seriously", "bruised a powerful ego", "killed a man in cold blood",
            "failed a big project", "blew through my budget", "didn't uphold politcally correct ideals", "embezzled money", "tried to convert everyone around me to my religion", "revealed that I don't like cheese",
            "fell in with a bad crew", "got caught looking through the leader's things", "tricked a coworker into doing my work for me"
    };
    private static final String[] doSomethingHeroic = new String[]{
            "do something heroic", "save the town", "save the kingdom", "save the world", "save my family", "rescue a damsel in distress", "write the most beautiful song",
            "slay a great beast", "sacrifice myself for a friend", "complete the eating challenge at my local tavern", "go on an epic journey", "master the blade",
            "discover eternal life", "start a family"
    };
    private static final String[] creatures = new String[]{
            "goblins", "wild dogs", "jackals", "tigers", "lions", "owlbears", "monkeys", "brown bears", "bobcats", "vipers", "pumas", "skeletons", "zombies", "tarantulas", "demons", "angels", "humans", "stray cats",
            "dragons", "basilisks", "falcons", "eagles", "kobold", "gnolls", "oozes", "rowdy teenagers", "hooligans"
    };
    private static final String[] verbing = new String[]{
            "drinking", "singing", "dancing around", "partying", "relaxing in a hot tub", "eating delicacies", "knitting scarves", "whittling art pieces", "painting", "splitting logs", "diving for treasure", "sleeping", "napping", "laughing at halflings"
    };
    private static final String[] relatives = new String[]{
            "crew", "family", "friends", "co-workers", "brothers", "sisters", "comrades", "servants", "business partners", "classmates"
    };
    private static final String[] aggressiveVerbed = new String[]{
            "attacked", "assaulted", "accosted", "killed", "murdered", "mutilated", "robbed", "mugged", "pranked", "drained of fluids", "made fun of", "rubbed", "gutted", "taken out", "taken out (on a date)"
    };
    private static final String[] hostileParty = new String[]{
            "dragon", "group of kobold", "group of goblins", "cult", "skeleton platoon", "zombie horde", "basement of vampires", "murder of crows", "shiver of sharks", "flock of dracoliches", "triplet of gnomes in a trenchcoat"
    };
    private static final String[] randomObject = new String[]{
            "sword", "rubber ducky", "bottle", "jar of peanut butter", "pineapple", "hammer", "nail", "screw", "instrument", "egg", "crystal", "dagger", "potion", "spear", "shield", "armor", "pet dog", "macguffin"
    };
    private static final String[] randomAbility = new String[]{
            "strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma", "rizz"
    };
    private static final String[] mysterySite = new String[]{
            "abandoned building", "ominous cave", "majestic clearing in a thick wood", "ginormous ravine in the earth", "crystalline cavern", "mysterious ruins", "washed up shipwreck on the shore", "gigantic skeleton in the woods",
            "forgotten temple on a hill", "ancient structure", "forbidden zone", "wasteland", "liminal space", "underground chamber beneath a well", "dungeon"
    };
    private static final String[] mysteryEntity = new String[]{
            "unknown god", "archdemon", "extraterrestrial being", "unknowable horror", "benevolent angel", "beautiful goddess", "long dead king", "great old one", "aspect of the gods", "cloudy figure wrapped in smoke",
            "flaming figure that shone brightly", "crackling figure clothed in crystals of ice", "thunderous figure arcing with lightning", "crumbling figure formed of earth", "caustic figure dripping with green ooze"
    };

    /**
     * returns a string of text describing a randomly generated backstory for a character..
     * @param pchar the playerCharacter to generate a backstory for
     * @return the string containing the backstory
     */
    public static String getBackstory(PlayerCharacter pchar) {
        Random rand = new Random();
        String backstory = "Error";

        location1 = RandomNameGenerator.getPlaceName();
        location2 = RandomNameGenerator.getPlaceName();
        String background = getRandom(backgrounds);
        String pclass = pchar.getCharacterClass();
        int introNum = rand.nextInt(4);
        int ctaNum = rand.nextInt(4);

        switch (introNum) { //DO NOT USE APOSTROPHE OR OTHER UNESCAPED CHARACTERS
            case 0 -> backstory = MessageFormat.format("Growing up in {0} was {1}. I {2}, which meant that {3}.\n" +
                    "These circumstances led me to life as a(n) {4}, but nothing lasts forever.\n",
                    location1, getRandom(adjective1), getRandom(wasInSituation), getRandom(somethingHappenedToMe), background);
            case 1 -> backstory = MessageFormat.format("I was not always a(n) {0}, I grew up as a(n) {1} {2} in {3}. " +
                            "\nAfter I {4}, they fired me, which led to my current occupation: a {5}. But being a {5} wasn't my final destiny...\n",
                    pclass, getRandom(occupationModifier), getRandom(backgrounds), location1, getRandom(didSomethingBad), background);
            case 2 -> backstory = MessageFormat.format("They should write songs about {0}s like me. I may have started my life in {1} as a {2}, but I always dreamt I\n" +
                    "would {3} and earn the respect of everyone. Unfortunately, the gods had other plans.\n", pclass, location1, background, getRandom(doSomethingHeroic));
            case 3 -> backstory = MessageFormat.format("As a kid, I was raised in the wilds around {0} by {1}. I {2}, which is to say,\n" +
                    "life was {3}. Eventually, my parents and fellow {1} thought I should go be with my own kind. A kind {5}\n" +
                    "took me in to teach me to be a(n) {6} {7}.\n", location1, getRandom(creatures), getRandom(wasInSituation), getRandom(adjective1), getRandom(creatures), background, getRandom(occupationModifier), background);
        }

        switch (ctaNum) { //DO NOT USE APOSTROPHE OR OTHER UNESCAPED CHARACTERS
            case 0 -> backstory = backstory + MessageFormat.format("\nOne night in {0}, while I was {1} with my {2}, we were {3} by a {4}. After the tradgedy,\n" +
                            "I swore to never let another person be {3} again, and so I took up arms as a {5}.\n",
                    location1, getRandom(verbing), getRandom(relatives), getRandom(aggressiveVerbed), getRandom(hostileParty), pclass);
            case 1 -> backstory = backstory + MessageFormat.format("\nBeing a {0} does not pay enough for my taste, so when I overheard something about a high-paying job\n" +
                    "while {1} in {2}, I was interested. All I needed was my trusty {3} and my {4} to\n" +
                    "complete the quest, make sure the {5} was {6}, and claim my coin. And that is how I became an adventurer.",
                    background, getRandom(verbing), location2, getRandom(randomObject), getRandom(randomAbility), getRandom(hostileParty), getRandom(aggressiveVerbed));
            case 2 -> backstory = backstory + MessageFormat.format("\nOne day, after a long night of {6}, some of my {0}, my friend {1} and I were exploring a(n)\n" +
                            "{2} near {3}. Unfortunately, I was separated from them at some point, and found myself standing in front of a {4}.\n" +
                            "I could feel their voice stirring something within me, reminding me of my ideals and strengthening my resolve. If I\n" +
                            "wanted to achieve my dreams as a {5}, I could not just go {6} willy-nilly any longer. I needed to become an adventurer.",
                    getRandom(relatives), RandomNameGenerator.getHumanName(), getRandom(mysterySite), location2, getRandom(mysteryEntity), pclass, getRandom(verbing));
            case 3 -> backstory = backstory + MessageFormat.format("\nOne day, while walking through {0}, a place I was not familiar with, a group of people approached me,\n" +
                            "hailing me as the chosen one, praising my {1} and {2} in my honor. The leader approached me, introducing themself as {6}.\n" +
                            "They claimed I had been sent by a(n) {3} to rid the land of the {4} that was oppressing the people. They led me to\n" +
                            "a(n) {7} and bestowed me with a holy {5}, then sent me on my way. That is how I became an adventurer.",
                    location2, getRandom(randomAbility), getRandom(verbing), getRandom(mysteryEntity), getRandom(hostileParty), getRandom(randomObject), RandomNameGenerator.getElfName(), getRandom(mysterySite));

        }
        return backstory;//

    }

    public static void testEntity(int i){
        for (int j = 0; j < i; j++) {
            System.out.println(getRandom(mysteryEntity));
        }
        System.out.println("----------");
        for (int j = 0; j < i; j++) {
            System.out.println(getRandom(mysterySite));
        }
        System.out.println("----------");

        for (int j = 0; j < i; j++) {
            System.out.println(getRandom(backgrounds));
        }
        System.out.println("----------");
        
        for (int j = 0; j < i; j++) {
            System.out.println(getRandom(creatures));
        }
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
    //One day, after a long night of drinking, some of my [relatives], my friend [getName] and I were exploring a(n)
    // [mysterySite] near [Location2], but I was separated from them at some point, and found myself standing in front of a [MysteryEntity].
    //I could feel its voice stirring something within me, reminding me of my ideals and strengthening my resolve. If I
    //wanted to achieve my dreams as a [Class], I couldn't just go [verbing] around any longer. I needed to become an adventurer.

    /*Call to adventure 4
    One day, while walking through [Location2], a place I was not familiar with, a group of people approached me,
    hailing me as the chosen one, praising my [ability] and [verbing] in my honor. The leader approached me, introducing themself as [getName].
    They claimed I had been sent by a(n) [mysteryEntity] to rid the land of the [hostileParty] that was oppressing the people. They led me to
    a(n) [mysterySite] and bestowed me with a holy [randomObject], then sent me on my way. That is how I became an adventurer.
     */
}