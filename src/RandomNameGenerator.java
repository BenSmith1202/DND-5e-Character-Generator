import java.util.Random;

/**
 * @author Ben Smith, David Olinger
 * Randomly generates a name from lists of syllables
 */
public class RandomNameGenerator { //Generates Random Names for Characters! 100% of content developed by our team.

    private static String getRandom(String[] array) { //returns a random String from an array
        int index = (int)(Math.round(Math.random() * (array.length-1)));
        return array[index];

    }
    private static final String[] humanNameSyls = new String[]{"ra", "ba", "lar", "tab", "ga", "ben", "dav", "log", "pre", "car", "rop", "dav", "sar",
            "lit", "pog", "frag", "slag", "pic", "hor", "lee", "smit", "oll", "in", "ger", "di", "kin", "son", "dell", "ing", "er", "win", "rick", "tal",
            "ro", "to", "bo", "ry", "co", "ca", "well", "max", "jo", "co", "la", "so", "tay"};

    private static final String[] dwarfNameSyls = new String[]{"tik", "lik", "dik", "pik", "puk", "duk", "luk", "tuk", "arz", "alz" , "anz", "urz",
            "unz", "ulz", "rok", "nok", "bok", "sok", "ruk", "nuk", "dwar", "vy", "suk", "buk", "en", "ger", "dale", "tal", "mith", "ko", "ka", "darl", "karl", "snarl", "barl",
            "jarl", "nug", "rog", "rik", "nik", "pik", "akz", "daye", "mond", "mund", "trund"};

    private static final String[] elfNameSyls = new String[]{"dru", "ehr", "grim", "lynn", "wynn", "ev", "eth", "gael", "el", "tar", "bryl", "jan", "dar",
            "ero", "lith", "gant", "faor", "fho", "fyl", "ha", "la", "ri", "paer", "ril", "thil", "aerm", "aum", "rath", "cali", "ban", "wisp", "bel",
            "droth", "thor", "idan", "ian", "rian", "lian", "trine", "rina", "dal", "yor", "bel", "naith", "evos", "as", "sin", "lil", "sus" };

    private static final String[] elfSurnames = new String[]{"leaf", "branch", "river", "stone", "ice", "flame", "cove", "birch", "oak", "dawn", "dusk",
            "flax", "flood", "gale", "breeze", "zephyr", "air", "sky", "ash", "silk", "vine", "jewel", "pond", "marsh", "moon", "star", "sun", "wild", "tide",
            "heath", "hawk", "reef", "frost", "bud", "jay", "pine", "aspen", "cedar", "grove", "thorn", "wisp", "ink", "rook", "tree", "trunk", "bark", "stem",
            "lord", "sage", "fruit", "seed", "sky", "storm", "rain", "apple", "mage", "lake", "swamp", "sea"};

    private static final String[] humanSurnames = new String[]{"wheeler", "chapman", "smith", "olinger", "coward", "dempster", "davis", "fitz", "hurst",
            "shaw", "townsend", "cruikshank", "moody", "lark", "taylor", "butcher", "gouy", "pozu", "heavyarms", "wheezer", "foster", "folger", "trombka",
            "toms", "stanski", "mamajek", "jordan", "arkwright", "brewster", "walker", "marshall", "turner", "johnson", "lister", "lucky", "ebert", "wing", "williams",
            "brown", "jones", "miller","rodriguez", "wilson", "anderson", "moore", "thompson", "lewis", "king", "matteran", "lucio", "hall", "green", "adams", "narn",
            "skaye", "roberts", "nickel", "denarii", "jupiter", "mars", "reaker", "fulloat", "spinner", "power", "garnet", "flint",
            "array", "stinger", "chrysos", "million"};

    private static final String[] dwarfSurnamesModifyer = new String[]{"strong", "steel", "dark", "stormy", "diamond", "ruby", "onyx", "iron", "golden", "stoney",
            "blazing", "slaughter", "war", "lumber", "rock", "splitter", "dwarven", "flinty", "mica", "granite", "marble", "under", "over", "twisted", "welded", "scrawny"};
    private static final String[] dwarfSurnamesObject = new String[]{"crown", "sword", "pick", "mine", "gem", "flint", "rock", "armor", "weapon", "tools", "boots", "passage",
            "dwarf", "blade", "edge", "head", "foot", "fist", "fists", "lord", "forge", "field", "drink", "ale", "plow", "beam", "plate", "guard", "gourd", "cheese",
            "wood", "stone", "crystal", "hammer", "chisel", "saw"};
    private static final String[] locationNames = new String[]{"City", "Mountain", "Hill", "Town", "Village", "Palace", "Swamp", "Forest", "Plateau", "Grove",
    "Valley", "Island", "Lake", "Sea", "Hamlet", "Wood", "Wetlands", "City", "Mountain","Harbor", "Cove", "Town", "Village", "Landing",
    "Crossroads", "Springs", "Creek", "Heights", "Passage", "Archipelago", "Bay", "Canyon", "Lagoon", "Tundra", "Desert"};

    /**
     * Creates a name (first and last) for a dwarf character, using randomly chosen syllables suited to the style of
     * dwarvish names, and picking a random surname consisting of a modifier (like stormy) and an object (like crown).
     * @return a stylish randomized name for a dwarf character.
     */
    public static String getDwarfName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        firstNameBuilder.append(getRandom(dwarfNameSyls));               //pick two syllables for the first name
        firstNameBuilder.append(getRandom(dwarfNameSyls));
        int r = random.nextInt(2);                                                             //sometimes the name gets an extra syllable
        if (r != 1){firstNameBuilder.append(getRandom(dwarfNameSyls));} //sometimes the names get an extra syllable
        firstNameBuilder.append(" ");                                                                //put a space between names
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1); //capitalize
        lastNameBuilder.append(getRandom(dwarfSurnamesModifyer));  //dwarf names have a modifyer which
        lastNameBuilder.append(getRandom(dwarfSurnamesObject));      //gets added before an object
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1);//capitalize and return full name
    }
    /**
     * Creates a name (first and last) for a human character, using randomly chosen syllables suited to the style of
     * human names, and picking a random surname.
     * @return a stylish randomized name for a human character.
     */
    public static String getHumanName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        firstNameBuilder.append(getRandom(humanNameSyls)); //pick two syllables for the first name
        firstNameBuilder.append(getRandom(humanNameSyls));
        int r = random.nextInt(2);
        if (r != 1){firstNameBuilder.append(getRandom(humanNameSyls));} //sometimes the names get an extra syllable
        firstNameBuilder.append(" ");
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1); //capitalize
        lastNameBuilder.append(getRandom(humanSurnames)); //pick random last name
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1); //capitalize, build, return
    }
    /**
     * Creates a name (first and last) for an elf character, using randomly chosen syllables suited to the style of
     * elven names, and picking a random surname consisting of two nature themed words (i.e. Winterbirch).
     * @return a stylish randomized name for an elf character.
     */
    public static String getElfName(){
        StringBuilder firstNameBuilder = new StringBuilder();
        StringBuilder lastNameBuilder = new StringBuilder();
        Random random = new Random();
        firstNameBuilder.append(getRandom(elfNameSyls)); //picks two syllables for the name
        firstNameBuilder.append(getRandom(elfNameSyls));
        int r = random.nextInt(2);
        if (r != 1){firstNameBuilder.append(getRandom(elfNameSyls));} //sometimes they get an extra syllable
        firstNameBuilder.append(" ");
        String firstName = firstNameBuilder.substring(0,1).toUpperCase() + firstNameBuilder.substring(1); //capitalize
        lastNameBuilder.append(getRandom(elfSurnames)); //pick two last name parts
        lastNameBuilder.append(getRandom(elfSurnames));
        return firstName + lastNameBuilder.substring(0,1).toUpperCase() + lastNameBuilder.substring(1); //capitalize, build, return
    }

    /**
     * Creates a random place name using various name syllables and various place types
     * @return = place name
     */
    public static String getPlaceName(){
        StringBuilder identifier = new StringBuilder();
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0 -> { //elven name
                identifier.append(getRandom(elfNameSyls));
                identifier.append(getRandom(dwarfNameSyls));
                int r = random.nextInt(2);
                if (r != 1) {
                    identifier.append(getRandom(elfNameSyls));
                }
            }
            case 1 -> { //dwarven name
                identifier.append(getRandom(dwarfNameSyls));
                identifier.append(getRandom(elfNameSyls));
                int r2 = random.nextInt(2);
                if (r2 != 1) {
                    identifier.append(getRandom(dwarfNameSyls));
                }
            }
            case 3 -> { //human name
                identifier.append(getRandom(dwarfNameSyls));
                identifier.append(getRandom(humanNameSyls));
                int r3 = random.nextInt(2);
                if (r3 != 1) {
                    identifier.append(getRandom(elfNameSyls));
                }
            }
        }
        int r4 = random.nextInt(10);
        String locationName;
        if (r4 <= 5)
        {
            identifier.append(" ");
            locationName = identifier.substring(0,1).toUpperCase() + identifier.append(getRandom(locationNames)).substring(1); //capitalize
        } else {
            locationName = identifier.substring(0,1).toUpperCase() + identifier.substring(1); //capitalize
        }
        return locationName;
    }
}

