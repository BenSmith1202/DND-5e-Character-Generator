import java.util.Random;

/**
 * @author Ben Smith, David Olinger
 * Generates a random dnd personality
 */
public class RandomPersonaGenerator {

    /**
     * Gets a random element from the array and returns it
     * @param array The array you want to return a random element from.
     * @return a random element from a given array.
     */
    private static String getRandom(String[] array) { //returns a random String from an array
        int index = (int)(Math.round(Math.random() * (array.length-1)));
        return array[index];

    }

    /**
     * Below are all the various Ideals, Bonds, and Flaws that have been mostly taken from DND handbooks, some added by us
     */
    private static final String[] generalIdeals = new String[]{ //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "Aspiration. I seek to prove my self worthy of my god's favor by matching my actions against his or her teachings. (Any)",
            "Aspiration. I'm determined to make something of myself. (Any)",
            "Honesty. Art should reflect the soul; it should come from within and reveal who we really are. (Any)",
            "Destiny. Nothing and no one can steer me away from my higher calling. (Any)",
            "Aspiration. I work hard to be the best there is at my craft. (Any)",
            "Self-Knowledge. If you know yourself, there's nothing left to know. (Any)",
            "Family. Blood runs thicker than water. (Any)",
            "Glory. I must earn glory in battle, for myself and my clan. (Any)",
            "Aspiration. Someday I'll own my own ship and chart my own destiny. (Any)",
            "Nation. My city, nation, or people are all that matters. (Any)",
            "Aspiration. I'm going to prove that I'm worthy of a better life. (Any)",
            "Fulfillment. I want to live a life that's worth living. (Any)",
            "Kindness. No matter my goals I must be kind and loving to those around me. (Any)"
    };

    private static final String[] lawfulIdeals = new String[]{  //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "Faith. I trust that my deity will guide my actions. I have faith that if I work hard, things will go well. (Lawful)",
            "Power. I hope to one day rise to the top of my faith's religious hierarchy. (Lawful)",
            "Fairness. I never target people who can't afford to lose a few coins. (Lawful)",
            "Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld. (Lawful)",
            "Honor. I don't steal from others in the trade. (Lawful)",
            "Tradition. The stories, legends, and songs of the past must never be forgotten. (Lawful)",
            "Fairness. No one should get preferential treatment before the law, and no one is above the law. (Lawful)",
            "Community. It is the duty of all civilized people to strengthen the bonds of community and the security of civilization. (Lawful)",
            "Logic. Emotions must not cloud our sense of what is right and true, or our logical thinking. (Lawful)",
            "Responsibility. It is my duty to respect the authority of those above me, just as those below me must respect mine. (Lawful)",
            "Honor. If I dishonor myself, I dishonor my whole clan. (Lawful)",
            "Logic. Emotions must not cloud our logical thinking. (Lawful)",
            "Fairness. We all do the work, so we all share in the rewards. (Lawful)",
            "Responsibility. I do what I must and obey just authority. (Lawful)",
            "Community. We have to take care of each other because no one else is going to do it. (Lawful)"
    };

    private static final String[] neutralIdeals = new String[]{  //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "People. I'm loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)",
            "People. I like seeing the smiles on people's faces when I perform. That's all that matters. (Neutral)",
            "Sincerity. There's no good pretending to be something I'm not. (Neutral)",
            "People. I'm committed to the people I care about, not to ideals. (Neutral)",
            "Live and Let Live. Meddling in the affairs of others only causes trouble. (Neutral)",
            "Nature. The natural world is more important than all the constructs of civilization. (Neutral)",
            "Knowledge. The path to power and self-improvement is through knowledge. (Neutral)",
            "Self-improvement. The goal of a life of study is the betterment of oneself. (Neutral)",
            "People. I'm committed to my crewmates, not to ideals. (Neutral)",
            "Ideals aren't worth killing for or going to war for. (Neutral)",
            "People. I help people who help me--that's what keeps us alive. (Neutral)",
            "Survival. Living to see another day is more important than any ideal. (Neutral)",
            "Balance. Excess in anything is unnecessary, balance is always desired. (Neutral)",
            "Understanding. The goal of life is to understand the lives of those around you. (Neutral)",
            "Mud. Nothing matters more in life than the joy I get from mud and its muddy qualities. (Neutral)"
    };

    private static final String[] chaoticIdeals = new String[]{  //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "Change. We must help bring about the changes the gods are constantly working in the world. (Chaotic)",
            "Independence. I am a free spirit--no one tells me what to do. (Chaotic)",
            "Creativity. I never run the same con twice. (Chaotic)",
            "Freedom. Chains are meant to be broken, as are those who would forge them. (Chaotic)",
            "Creativity. The world is in need of new ideas and bold action. (Chaotic)",
            "Freedom. Tyrants must not be allowed to oppress the people. (Chaotic)",
            "Freedom. Everyone should be free to pursue his or her livelihood. (Chaotic)",
            "Free Thinking. Inquiry and curiosity are the pillars of progress. (Chaotic)",
            "Independence. I must prove that I can handle myself without the coddling of my family. (Chaotic)",
            "Change. Life is like the seasons, in constant change, and we must change with it. (Chaotic)",
            "No Limits. Nothing should fetter the infinite possibility inherent in all existence. (Chaotic)",
            "Freedom. The sea is freedom--the freedom to go anywhere and do anything. (Chaotic)",
            "Independence. When people follow orders blindly they embrace a kind of tyranny. (Chaotic)",
            "Change. The low is lifted up, and the high and mighty are brought down. Change is the nature of things. (Chaotic)",
            "Destruction. Things being destroyed is entertaining, and thus a worthwhile path for life. (Chaotic)",
            "Noise. The world is too quiet, and must be filled with my noise. (Chaotic)",
            "Excitement. Life and ideals are worthless if boring, I desire excitement above all else. (Chaotic)",
            "Adventure. I set off not knowing where I will go, the powers that be shall guide my steps. (Chaotic)",
            "Improvisation. I never plan more than one step ahead, life is meant to be improvised. (Chaotic)",
            "Jumping. I don't like how the ground feels and am dedicated to always jumping. (Chaotic)"
    };

    private static final String[] goodIdeals = new String[] {  //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "Charity. I always try to help those in need, no matter what the personal cost. (Good)",
            "Charity. I distribute money I acquire to the people who really need it. (Good)",
            "Friendship. Material goods come and go. Bonds of friendship last forever. (Good)",
            "Charity. I steal from the wealthy so that I can help people in need. (Good)",
            "Redemption. There's a spark of good in everyone. (Good)",
            "Beauty. When I perform, I make the world better than it was. (Good)",
            "Respect. People deserve to be treated with dignity and respect. (Good)",
            "Generosity. My talents were given to me so that I could use them to benefit the world. (Good)",
            "Greater Good. My gifts are meant to be shared with all, not used for my own benefit. (Good)",
            "Respect. Respect is due to me because of my position, but all people regardless of station deserve to be treated with dignity. (Good)",
            "Noble Obligation. It is my duty to protect and care for the people beneath me. (Good)",
            "Greater Good. It is each person's responsibility to make the most happiness for the whole tribe. (Good)",
            "Beauty. What is beautiful points us beyond itself toward what is true. (Good)",
            "Respect. The thing that keeps a ship together is mutual respect between captain and crew. (Good)",
            "Greater Good. Our lot is to lay down our lives in defense of others. (Good)",
            "Respect. All people, rich or poor, deserve respect. (Good)"
    };

    private static final String[] evilIdeals = new String[] {  //Ideals from 5E Players Handbook and Dungeon Master's Guide
            "Greed. I will do whatever it takes to become wealthy. (Evil)",
            "Greed. I'm only in it for the money and fame. (Evil)",
            "Might. If I become strong, I can take what I want--what I deserve. (Evil)",
            "Greed. I'm only in it for the money. (Evil)",
            "Power. Solitude and contemplation are paths toward mystical or magical power. (Evil)",
            "Power. If I can attain more power, no one will tell me what to do. (Evil)",
            "Might. The strongest are meant to rule. (Evil)",
            "Power. Knowledge is the path to power and domination. (Evil)",
            "Master. I'm a predator, and the other ships on the sea are my prey. (Evil)",
            "Might. In life as in war, the stronger force wins. (Evil)",
            "Retribution. The rich need to be shown what life and death are like in the gutters. (Evil)"
    };

    private static final String[] bonds = new String[]{  //Bonds from 5E Players Handbook and Dungeon Master's Guide
            "I would die to recover an ancient artifact of my faith that was lost long ago.",
            "I will someday get revenge on the corrupt temple hierarchy who branded me a heretic.",
            "I owe me life to the priest who took me in when my parents died.",
            "Everything I do is for the common people.",
            "I will do anything to protect the temple where I served.",
            "I seek to preserve a sacred text that my enemies consider heretical and seek to destroy.",
            "I fleeced the wrong person and must work to ensure that this individual never crosses paths with me or those I care about.",
            "I owe everything to my mentor--a horrible person who's probably rotting in jail somewhere.",
            "Somewhere out there I have a child who doesn't know me. I'm making the world better for him or her.",
            "I come from a noble family, and one day I'll reclaim my lands and title from those who stole them from me.",
            "A powerful person killed someone I love. Someday soon, I'll have my revenge.",
            "I swindled and ruined a person who didn't deserve it. I seek to atone for my misdeeds but might never be able to forgive myself.",
            "I'm trying to pay off an old debt I owe to a generous benefactor.",
            "My ill-gotten gains go to support my family.",
            "Something important was taken from me, and I aim to steal it back.",
            "I will become the greatest thief that ever lived.",
            "I'm guilty of a terrible crime. I hope I can redeem myself for it.",
            "Someone I loved died because of a mistake I made. That will never happen again.",
            "My instrument is my most treasured possession, and it reminds me of someone I love.",
            "Someone stole my precious instrument, and someday I'll get it back.",
            "I want to be famous, whatever it takes.",
            "I idolize a hero of the old tales and measure my deeds against that person's.",
            "I will do anything to prove myself superior to me hated rival.",
            "I would do anything for the other members of my old troupe.",
            "I have a family, but I have no idea where they are. One day, I hope to see them again.",
            "I worked the land, I love the land, and I will protect the land.",
            "A proud noble once gave me a horrible beating, and I will take my revenge on any bully I encounter.",
            "My tools are symbols of my past life, and I carry them so that I will never forget my roots.",
            "I protect those who cannot protect themselves.",
            "I wish my childhood sweetheart had come with me to pursue my destiny.",
            "The workshop where I learned my trade is the most important place in the world to me.",
            "I created a great work for someone, and then found them unworthy to receive it. I'm still looking for someone worthy.",
            "I owe my guild a great debt for forging me into the person I am today.",
            "I pursue wealth to secure someone's love.",
            "One day I will return to my guild and prove that I am the greatest artisan of them all.",
            "I will get revenge on the evil forces that destroyed my place of business and ruined my livelihood.",
            "Nothing is more important than the other members of my hermitage, order, or association.",
            "I entered seclusion to hide from the ones who might still be hunting me. I must someday confront them.",
            "I'm still seeking the enlightenment I pursued in my seclusion, and it still eludes me.",
            "I entered seclusion because I loved someone I could not have.",
            "Should my discovery come to light, it could bring ruin to the world.",
            "My isolation gave me great insight into a great evil that only I can destroy.",
            "I will face any challenge to win the approval of my family.",
            "My house's alliance with another noble family must be sustained at all costs.",
            "Nothing is more important that the other members of my family.",
            "I am in love with the heir of a family that my family despises.",
            "My loyalty to my sovereign is unwavering.",
            "The common folk must see me as a hero of the people.",
            "My family, clan, or tribe is the most important thing in my life, even when they are far from me.",
            "An injury to the unspoiled wilderness of my home is an injury to me.",
            "I will bring terrible wrath down on the evildoers who destroyed my homeland.",
            "I am the last of my tribe, and it is up to me to ensure their names enter legend.",
            "I suffer awful visions of a coming disaster and will do anything to prevent it.",
            "It is my duty to provide children to sustain my tribe.",
            "It is my duty to protect my students.",
            "I have an ancient text that holds terrible secrets that must not fall into the wrong hands.",
            "I work to preserve a library, university, scriptorium, or monastery.",
            "My life's work is a series of tomes related to a specific field of lore.",
            "I've been searching my whole life for the answer to a certain question.",
            "I sold my soul for knowledge. I hope to do great deeds and win it back.",
            "I'm loyal to my captain first, everything else second.",
            "The ship is most important--crewmates and captains come and go.",
            "I'll always remember my first ship.",
            "In a harbor town, I have a paramour whose eyes nearly stole me from the sea.",
            "I was cheated of my fair share of the profits, and I want to get my due.",
            "Ruthless pirates murdered my captain and crewmates, plundered our ship, and left me to die. Vengeance will be mine.",
            "I would lay down my life for the people I served with.",
            "Someone saved my life on the battlefield. To this day, I will never leave a friend behind.",
            "My honor is my life. ",
            "I'll never forget the crushing defeat my company suffered or the enemies who dealt it.",
            "Those who fight beside me are those worth dying for.",
            "I fight for those who cannot fight for themselves.",
            "My town or city is my home, and I'll fight to defend it.",
            "I sponsor an orphanage to keep others from enduring what I was forced to endure.",
            "I owe my survival to another urchin who taught me to live on the streets.",
            "I owe a debt I can never repay to the person who took pity on me.",
            "I escaped my life of poverty by robbing an important person, and I'm wanted for it.",
            "No one else is going to have to endure the hardships I've been through."
    };

    public static final String[] flaws = new String[]{ //from https://www.kassoon.com/dnd/5e/personality-ideals-bonds-flaws/
    "I judge others harshly, and myself even more severely.",
    "I put too much trust in those who wield power within my temple's hierarchy.",
    "My piety sometimes leads me to blindly trust those that profess faith in my god.",
    "I am inflexible in my thinking.",
    "I am suspicious of strangers and expect the worst of them.",
    "Once I pick a goal, I become obsessed with it to the detriment of everything else in my life.",
    "Boats make me seasick.",
    "I talk to myself, and I don't make friends easily.",
    "I believe that I'm intellectually superior to people from other cultures and have much to teach them.",
    "I've picked up some unpleasant habits living among goblins, lizardfolk, or orcs.",
    "I complain about everything.",
    "I wear a tribal mask and never take it off.",
    "I have a secret fear of some common wild animal - and in my work, I see them everywhere.",
    "I can't leave a room without searching it for secret doors.",
    "When I'm not exploring dungeons or ruins. I get jittery and impatient.",
    "I have no time for friends or family. I spend every waking moment thinking about and preparing for my next expedition.",
    "When given the choice of going left or right, I always go left.",
    "I can't sleep except in total darkness.",
    "I indulge in a habit that threatens my reputation or my health.",
    "I'll do absolutely anything to win.",
    "I ignore anyone who doesn't compete and anyone who loses to me.",
    "I have lingering pain from old injuries.",
    "Any defeat or failure on my part is because my opponent cheated.",
    "I must be the captain of any group I join.",
    "I'm unable to distinguish between the letter and the spirit of the law.",
    "I seem like a harsh judge to others, but I judge myself most harshly of all.",
    "I can't help but pocket any trinket or coin I come across, no matter how worthless.",
    "I'm convinced that I'm better and stronger than members of other guilds, isolated as they are from the realities of life and death.",
    "I've never lied once in my life. What? No, I'm not crossing my fingers!",
    "I do everything big! Subtlety? I don't know the meaning of subtlety! Oh, that's a problem?",
    "Being a spy in wartime is painful. I've seen so much suffering, I think I'm losing my mind.",
    "I can't focus on my mission. I just want to carouse and sing and play!",
    "I can't afford to trust anyone. Not. Anyone.",
    "If you question my courage, I will never back down.",
    "HrrrGGGAAAARRuuuh! [My anger in battle led to the death of a loved one.]",
    "I'm as stubborn as a batterboar.",
    "I'm so convinced of my superiority over soft, civilized people that I'll take great risks to prove it.",
    "I'm easily manipulated by people I find attractive.",
    "I'm not actually all that angry.",
    "I'll do anything to get my hands on something rare or priceless.",
    "I'm quick to assume that someone is trying to cheat me.",
    "No one must ever learn that I once stole money from guild coffers.",
    "I'm never satisfied with what I have—I always want more.",
    "I would kill to acquire a noble title.",
    "I'm horribly jealous of anyone who can outshine my handiwork. Everywhere I go, I'm surrounded by rivals.",
    "I drink too much, which causes me to miss the tide.",
    "I killed a drunk member of the City Watch in a brawl. I am terrified that they might find out.",
    "I oversell myself and make promises I can't keep when I want to impress someone.",
    "Book learning is a waste of time. I have no patience for people who don't speak from experience.",
    "I almost always cheat. I can't help myself.",
    "I believe doom follows me and that anyone who gets close to me will face a tragic end.",
    "I'm especially superstitious and live life seeking to avoid bad luck, wicked spirits, or the Mists.",
    "I've done unspeakable evil and will do anything to prevent others from finding out.",
    "I am exceptionally credulous and believe any story or legend immediately.",
    "I'm a skeptic and don't believe in the power of rituals, religion, superstition, or spirits.",
    "I know my future is written and that anything I do will lead to a prophesied end.",
    "I need to find the best in everyone and everything, even when that means denying obvious malice.",
    "I've seen the evil of a type of place—like forests, cities, or graveyards—and resist going there.",
    "I'm exceptionally cautious, planning laboriously and devising countless contingencies.",
    "I have a reputation for defeating a great evil, but that's a lie and the wicked force knows.",
    "I know the ends always justify the means and am quick to make sacrifices to attain my goals.",
    "Now that I've returned to the world, I enjoy its delights a little too much.",
    "I harbor dark, bloodthirsty thoughts that my isolation and meditation failed to quell.",
    "I am dogmatic in my thoughts and philosophy.",
    "I let my need to win arguments overshadow friendships and harmony.",
    "I'd risk too much to uncover a lost bit of knowledge.",
    "I like keeping secrets and won't share them with anyone.",
    "I am a braggart. I promote myself shamelessly.",
    "I am vain. I always wear the latest fashions.",
    "I am a glutton. I eat and drink to excess.",
    "I am a snob. I want only the finest things in life.",
    "I am lazy. I want others to take care of everything.",
    "I am overconfident. I overestimate my abilities.",
    "I have difficulty trusting strangers. Anyone could be a spy for the authorities.",
    "I am greedy. There Isn't much I won't do for money.",
    "I'm fixated on following official protocols.",
    "I'm obsessed with conspiracy theories and worried about secret societies and hidden demons.",
    "My house and bloodline make me the best!",
    "My secret could get me expelled from my house.",
    "My religious beliefs aren't widespread in my house.",
    "I'm working for a hidden faction in my house that gives me secret assignments.",
    "I'm easily distracted by an attractive person, which could be the death of me in the trials.",
    "Training for a lifetime to die in the end seems like a big waste of energy.",
    "I believe doom follows me and that anyone who gets close to me will face a tragic end.",
    "I'm convinced something is after me, appearing in mirrors, dreams, and places where no one could.",
    "I'm especially superstitious and live life seeking to avoid bad luck, wicked spirits, or the Mists.",
    "I've done unspeakable evil and will do anything to prevent others from finding out.",
    "I am exceptionally credulous and believe any story or legend immediately.",
    "I'm a skeptic and don't believe in the power of rituals, religion, superstition, or spirits.",
    "I know my future is written and that anything I do will lead to a prophesied end.",
    "I need to find the best in everyone and everything, even when that means denying obvious malice.",
    "I've seen the evil of a type of place—like forests, cities, or graveyards—and resist going there.",
    "I'm exceptionally cautious, planning laboriously and devising countless contingencies.",
    "I have a reputation for defeating a great evil, but that's a lie and the wicked force knows.",
    "I know the ends always justify the means and am quick to make sacrifices to attain my goals.",
    "I talk to animals; I believe they understand me, even if they do not.",
    "I growl at and bite anyone who gets too close to my food while I am eating.",
    "I strongly dislike enclosed spaces and require intoxication or firm encouragement to enter them.",
    "I robbed the wrong caravan once. The owner is a powerful merchant who holds a grudge.",
    "I'm an inveterate gambler.",
    "I judge people based on how well they stand their ground in a fight. I got not time for cowards...",
    "If there's a plan, I'll probably forget it. If I don't forget it, I'll probably ignore it.",
    "I get bored easily, and if nothing is happening I'll make something happen.",
    "Nothing is ever simple, and if it seems simple, I'll find a way to make it complicated.",
    "I tend to ignore sleep for days when I'm conducting research, often at the expense of my own health and safety.",
    "I'm incapable of admitting a flaw in my logic.",
    "I grow combative and unpredictable when I drink.",
    "I find civilian life difficult and struggle to say the right thing in social situations.",
    "My intensity can drive others away.",
    "I hold grudges and have difficulty forgiving others.",
    "I become irrational when innocent people are hurt.",
    "I sometimes stay up all night listening to the ghosts of my fallen enemies.",
    "I have difficulty caring about anyone or anything other than myself.",
    "Having grown up with wealth, I am careless with my finances. I overspend and am overly generous.",
    "The ends (my advancement) justify any means.",
    "I must have what I want and will brook no delay.",
    "My family has lost everything. I must keep up appearances, lest we become a laughingstock.",
    "I secretly question whether the gods care at all about us or what we do.",
    "I am terrified of what lies beyond the Gate to the Afterlife.",
    "I drink to dull the pain in the back of my head.",
    "I go a bit mad when I see blood.",
    "I can hear the voices of everyone I've killed. I see their faces. I can't be free of these ghosts.",
    "I easily lose track of time. My poor sense of time means I'm always late.",
    "I think the whole multiverse is out to get me.",
    "I'm always operating under a tight timeline, and I'm obsessed with keeping everything on schedule.",
    "I'm a kleptomaniac who covets shiny, sparkling treasure.",
    "I'm forgetful. Sometimes I can't remember even the simplest things.",
    "I never give away anything for free and always expect something in return.",
    "I have many vices and tend to indulge them.",
    "I'm always changing my mind—well, almost always.",
    "I have a crippling fear of wood.",
    "I have a crippling fear of stone.",
    "I have unbelievable arachnophobia.",
    "I am allergic to unfiltered water.",
    "Any time I tell a lie, I enter a coughing fit."

    };

    /**
     * Used to generate random personalities based on a given character
     * @param pchar the character to generate a persona for
     * @return a block of text representing the traits of this character personality.
     */
   public static String getPersona(PlayerCharacter pchar){ //returns a block of text describing a character's personality
       String alignment = pchar.getAlignment();
       StringBuilder personaBuilder = new StringBuilder();
       personaBuilder.append("\nPERSONALITY TRAITS:\nIdeals:\n");
       switch (alignment.charAt(0)) {
           case 'L' -> personaBuilder.append(getRandom(lawfulIdeals) + "\n"); //gets random ideals based on alignment.
           case 'N' -> personaBuilder.append(getRandom(neutralIdeals) + "\n");
           case 'C' -> personaBuilder.append(getRandom(chaoticIdeals) + "\n");
       }
       switch (alignment.charAt(1)) {
           case 'G' -> personaBuilder.append(getRandom(goodIdeals) + "\n");
           case 'N' -> personaBuilder.append(getRandom(neutralIdeals) + "\n");
           case 'E' -> personaBuilder.append(getRandom(evilIdeals) + "\n");
       }

       personaBuilder.append("Bond:\n"); //adds a random bond and flaw
       personaBuilder.append(getRandom(bonds) + "\n");
       personaBuilder.append("Flaw:\n");
       personaBuilder.append(getRandom(flaws) + "\n");
       return personaBuilder.toString();
   }
}
