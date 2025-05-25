import java.util.*;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator getNormalIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator getReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator getShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator(); // for-each поддержка
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
