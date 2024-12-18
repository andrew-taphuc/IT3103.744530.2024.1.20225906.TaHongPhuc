package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media_phucth> {

	public MediaComparatorByCostTitle() {
	}
	@Override
	public int compare(Media_phucth m1, Media_phucth m2) {
		return Comparator.comparing((Media_phucth m) -> -m.getCost()) // Descending cost
                .thenComparing(Media_phucth::getTitle)      // Ascending title
                .compare(m1, m2);
    }
}


