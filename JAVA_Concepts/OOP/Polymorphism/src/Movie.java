import java.util.Arrays;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

    public static Movie getMovie(String type, String title) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title, 10, new String[] {"Taiwan", "Australia"});
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {

    final int dangerLevel;
    final String[] locations;

    public Adventure(String title, int dangerLevel, String[] locations) {
        super(title);
        this.dangerLevel = dangerLevel;
        this.locations = locations;

        if(dangerLevel < 1 || dangerLevel > 10) {
            throw new IllegalArgumentException(STR."The danger level should between 1 to 10. Current dangerous Level:\{dangerLevel}");
        }

        System.out.println(STR."Creating Adventure movie..., the locations are:\{Arrays.toString(locations)}");
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Stimulate Happens");
        System.out.println(STR."They go to ... \{Arrays.toString(locations)}");
    }

}

class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }
}

class ScienceFiction extends Movie {
    public ScienceFiction(String title) {
        super(title);
    }
}