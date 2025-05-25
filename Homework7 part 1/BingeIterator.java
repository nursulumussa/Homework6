import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).getNormalIterator();
        }
    }

    public boolean hasNext() {
        while (seasonIndex < seasons.size()) {
            if (currentIterator != null && currentIterator.hasNext()) {
                return true;
            }
            seasonIndex++;
            if (seasonIndex < seasons.size()) {
                currentIterator = seasons.get(seasonIndex).getNormalIterator();
            }
        }
        return false;
    }

    public Episode next() {
        return currentIterator.next();
    }
}
