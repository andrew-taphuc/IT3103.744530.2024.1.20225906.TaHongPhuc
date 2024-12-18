package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media_phucth> {

	public MediaComparatorByTitleCost() {
	}
	@Override
	public int compare(Media_phucth m1, Media_phucth m2) {
		return Comparator.comparing(Media_phucth::getTitle)
                .thenComparing((m1Inner, m2Inner) -> Float.compare(m2Inner.getCost(), m1Inner.getCost()))
                .compare(m1, m2);
	}
}

