package com.genability.client.types;


import java.util.List;
import java.util.Set;


/**
 * This is a list of reading data. It extends our paginated list. 
 *
 * @param <ReadingData>
 */
public class ReadingList<ReadingData> extends PagedList<ReadingData> {

	private static final long serialVersionUID = 1L;

	protected Set<PropertyKey> quantityKeys;
	
	protected List<PropertyData> assumptions;

	public ReadingList() {
		super();
	}

	public ReadingList(List<ReadingData> list, PaginationInfo paginationInfo) {
		super(list, paginationInfo);
	}

	public ReadingList(List<ReadingData> list) {
		super(list);
	}

	public ReadingList(PaginationInfo paginationInfo) {
		super(paginationInfo);
	}

}
