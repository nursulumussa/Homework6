public class Main {
    public static void main(String[] args) {
        Series series = new Series();

        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1", 1200));
        season1.addEpisode(new Episode("S1E2", 1300));

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1", 1400));
        season2.addEpisode(new Episode("S2E2", 1500));

        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Normal:");
        EpisodeIterator it = season1.getNormalIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nReverse:");
        EpisodeIterator rev = season1.getReverseIterator();
        while (rev.hasNext()) System.out.println(rev.next());

        System.out.println("\nShuffle (seed 42):");
        EpisodeIterator shuf = season1.getShuffleIterator(42);
        while (shuf.hasNext()) System.out.println(shuf.next());

        System.out.println("\nBinge Mode:");
        EpisodeIterator binge = series.getBingeIterator();
        while (binge.hasNext()) System.out.println(binge.next());

        System.out.println("\nFor-each (season2):");
        for (Episode e : season2) {
            System.out.println(e);
        }
    }
}
