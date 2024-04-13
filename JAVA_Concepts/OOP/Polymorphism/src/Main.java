public class Main {
    public static void main(String[] args) {
        Movie tiffanyBreakfast = new Movie("Tiffany's Breakfast");
        tiffanyBreakfast.watchMovie();

        try {
            Movie tomCruise = new Adventure("Tom Cruise - 1", 11, new String[]{"Taipei", "Toronto"});
            tomCruise.watchMovie();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass());
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }

        Movie tomCruise2 = Movie.getMovie("Adventure", "Tom cruise - 2");
        tomCruise2.watchMovie();

        Movie alien = Movie.getMovie("Science Fiction", "Alien 1");
        alien.watchMovie();
    }
}
