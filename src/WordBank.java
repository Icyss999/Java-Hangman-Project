import java.util.Scanner;
public class WordBank {

    static final int CATEGORY_COUNT = 10;
    static final int WORDS_PER_CATEGORY = 4;


    public static String getCategoryName(int category) {
        switch (category) {
            case 1: return "Animals";
            case 2: return "Tourists";
            case 3: return "Foods";
            case 4: return "Sports";
            case 5: return "Jobs";
            case 6: return "Superhero in Marvel";
            case 7: return "Video Games";
            case 8: return "Spaces";
            case 9: return "Fruits";
            case 10: return "Programmings";
            default: return "";
        }
    }

    public static String getWord(int category, int wordIndex) {
        switch (category) {
            case 1:
                switch (wordIndex) {
                    case 0: return "dragons";
                    case 1: return "penquin";
                    case 2: return "giraffe";
                    default: return "elephants";
                }
            case 2:
                switch (wordIndex) {
                    case 0: return "angkor wat";
                    case 1: return "paris";
                    case 2: return "tokyo";
                    default: return "venice";
                }
            case 3:
                switch (wordIndex) {
                    case 0: return "sushi";
                    case 1: return "amok";
                    case 2: return "pizza";
                    default: return "hamburger";
                }
            case 4:
                switch (wordIndex) {
                    case 0: return "football";
                    case 1: return "basketball";
                    case 2: return "swimming";
                    default: return "badminton";
                }
            case 5:
                switch (wordIndex) {
                    case 0: return "doctor";
                    case 1: return "teacher";
                    case 2: return "engineer";
                    default: return "pilot";
                }
            case 6:
                switch (wordIndex) {
                    case 0: return "iron man";
                    case 1: return "scarlet witch";
                    case 2: return "doctor strange";
                    default: return "moon knight";
                }
            case 7:
                switch (wordIndex) {
                    case 0: return "dota";
                    case 1: return "csgo";
                    case 2: return "world of warcraft";
                    default: return "valorant";
                }
            case 8:
                switch (wordIndex) {
                    case 0: return "galaxy";
                    case 1: return "astronaut";
                    case 2: return "telescope";
                    default: return "saturn";
                }
            case 9:
                switch (wordIndex) {
                    case 0: return "banana";
                    case 1: return "mango";
                    case 2: return "pineapple";
                    default: return "strawberry";
                }
            case 10:
                switch (wordIndex) {
                    case 0: return "java";
                    case 1: return "python";
                    case 2: return "loop";
                    default: return "variable";
                }
            default:
                return "";
        }
    }


    private static String getAllHints(int category, int wordIndex) {
        switch (category) {
            case 1:
                switch (wordIndex) {
                    case 0: return "Mythical creatures that can breathe fire and fly.";
                    case 1: return "A black and white bird that cannot fly but can swim very well in cold water";
                    case 2: return "A tall animal with a very long neck and brown spots that eats leaves from trees";
                    default: return "Large animals with long trunks, big ears, and tusks.They are also known for their excellent memory.";
                }
            case 2:
                switch (wordIndex) {
                    case 0: return "A famous temple complex which located in Siem Reap ";
                    case 1: return "The capital city of France, famous for the Eiffel Tower,romantic atmosphere,and delicious pastries";
                    case 2: return "The capital city of Japan, famous for its anime,advanced technology,and delicious sushi ";
                    default: return "A beautiful city in Italy famous for its canals,gondola boats,and waterways instead of ordinary streets in many areas.";
                }
            case 3:
                switch (wordIndex) {
                    case 0: return "A popular Japanese dish made with rice and often combined with raw fish,vegetables,or seafood.";
                    case 1: return "A traditional Cambodian dish made with fish,coconut milk,and spices,usually steamed in banana leaves";
                    case 2: return "An Italian dish made with flat dough,tomato sauce,cheese,and various toppings.";
                    default: return "A popular fast food made with a bun,a cooked meat patty,and toppings such as lettuce,cheese,and tomatoes.";
                }
            case 4:
                switch (wordIndex) {
                    case 0: return "A popular sport in which two teams try to score goals by kicking a ball into the opponent’s net.Players cannot use their hands,except the goalkeeper.";
                    case 1: return "A sport in which two teams try to score points by throwing a ball through a high hoop.Players usually bounce the ball while moving.";
                    case 2: return "An activity or sport in which people move through water using their arms and legs.";
                    default: return "A sport in which players use rackets to hit a shuttlecock over a net. It can be played by two or four players.";
                }
            case 5:
                switch (wordIndex) {
                    case 0: return "A person who helps sick people,checks their health,and gives them medicine.";
                    case 1: return "A person who teaches students,explains lessons,and helps them learn new things.";
                    case 2: return "A person who designs,builds,or develops things such as buildings,machines,road,or computer systems.";
                    default: return "A person who controls and flies an airplane to transport passengers or cargo.";
                }
            case 6:
                switch (wordIndex) {
                    case 0: return "A superhero who wears a high-tech metal suit,can fly,and uses advanced technology to fight enemies.";
                    case 1: return "A powerful superhero who can use chaos magic,control minds,and change reality.She is known for her red energy powers and is one of the most powerful magic users in the Marvel universe.";
                    case 2: return "A superhero who uses magic,creates portals,and protects the world from supernatural threats.";
                    default: return "A mysterious superhero who gets his powers from an Egyptian moon god.He wears a white costume and fights criminals at night.";
                }
            case 7:
                switch (wordIndex) {
                    case 0: return "A popular multiplayer online battle arena game where two teams of five players choose heroes with unique abilities and fight to destroy the enemy's main base";

                    case 1: return "A competitive first-person shooter game where two teams fight as terrorists and counter-terrorists.Players use guns,plant bombs,and complete missions.";
                    case 2: return "An online fantasy game where players explore a huge world,complete quests,fight monsters,and join guilds.";
                    default: return "A tactical first-person shooter game where two teams of five players use guns and special abilities.One team plants a spike while the other tries to stop it.";
                }
            case 8:
                switch (wordIndex) {
                    case 0: return "A huge collection of stars,planets, as,and dust held together by gravity.Our solar system is part of one called the Milky Way.";
                    case 1: return "A person trained to travel into space,explore space stations,and conduct experiments beyond Earth.";
                    case 2: return "A tool used to observe distant objects in space,such as stars,planets,and galaxies,making them appear closer.";
                    default: return "The sixth planet from the Sun which famous for its beautiful rings made mostly of ice and rocky particles";
                }
            case 9:
                switch (wordIndex) {
                    case 0: return "A long, curved fruit with yellow skin and soft,sweet flesh.Monkeys are often associated with eating this fruit.";
                    case 1: return "A tropical fruit with yellow-orange flesh,a large flat seed,and a sweet taste.It can be eaten fresh or made into juice.";
                    case 2: return "A tropical fruit with a rough,spiky outer skin,a crown of green leaves,and sweet-and-sour yellow flesh.";
                    default: return "A small, red fruit with tiny seeds on its outer surface.It is often used in cakes,ice cream,and smoothies.";
                }
            case 10:
                switch (wordIndex) {
                    case 0: return "A popular programming language used to develop applications,games,and software systems.It follows object-oriented programming principles and can run on different platforms.";
                    case 1: return "A beginner-friendly programming language known for its simple syntax.It is commonly used in web development,artificial intelligence,data analysis,and automation ";
                    case 2: return "A programming concept that repeats a set of instructions multiple times until a condition is met or the repetition ends.";
                    default: return "Named storage locations in programming that hold data,such as numbers,text,or other values,which can be used and changed while a program runs.";
                }
            default:
                return "No hint available.";
        }
    }

    public static String getHint(int category, int wordIndex, int hintNumber) {
        String all = getAllHints(category, wordIndex);
        int start = 0;

        for (int i = 0; i < hintNumber; i++) {
            int bar = all.indexOf('|', start);
            if (bar == -1) {
                break; // no more hints, stay on the last one
            }
            start = bar + 1;
        }

        int end = all.indexOf('|', start);
        if (end == -1) {
            end = all.length();
        }
        return all.substring(start, end);
    }


    public static int pickRandomWordIndex() {
        return (int) (Math.random() * WORDS_PER_CATEGORY);
    }
    public static void printMenu() {
        System.out.println("Choose a category:");
        for (int i = 1; i <= CATEGORY_COUNT; i++) {
            System.out.println(i + ". " + getCategoryName(i));
        }
    }

    private static boolean isNumber(String text) {
        if (text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int resolveCategory(String input) {
        String text = input.trim();


        if (text.isEmpty()) {
            return -1;
        }

        if (isNumber(text)) {
            if (text.length() > 3) {
                return -1;
            }
            int number = Integer.parseInt(text);
            if (number >= 1 && number <= CATEGORY_COUNT) {
                return number;
            }
            return -1;
        }

        for (int i = 1; i <= CATEGORY_COUNT; i++) {
            if (getCategoryName(i).equalsIgnoreCase(text)) {
                return i;
            }
        }
        return -1;
    }

    public static int askUserForCategory(Scanner scanner) {
        int category;
        do {
            printMenu();
            System.out.print("Your choice (number or name): ");
            String input = scanner.nextLine();
            category = resolveCategory(input);

            if (category == -1) {
                System.out.println("Invalid choice, please try again.");
            }
        } while (category == -1);

        return category;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int category = askUserForCategory(scanner);
        int wordIndex = pickRandomWordIndex();
        String word = getWord(category, wordIndex);

        System.out.println("Category: " + getCategoryName(category));
        for (int i = 0; i < 2; i++) {
            System.out.println("Hint " + (i + 1) + ": " + getHint(category, wordIndex, i));
        }
    }
}

