package com.prodyna.esd.filesystem.filemanager.search;

public class OrSearchCriteria<T> implements SearchCriteria<T> {
    
    /**
     * @param sc1
     * @param sc2
     */
    public OrSearchCriteria(SearchCriteria<T> sc1, SearchCriteria<T> sc2) {
        super();
        this.sc1 = sc1;
        this.sc2 = sc2;
    }
    private SearchCriteria<T> sc1;
    private SearchCriteria<T> sc2;
    /**
     * @return the sc2
     */
    public SearchCriteria<T> getSc2() {
        return sc2;
    }
    /**
     * @param sc2 the sc2 to set
     */
    public void setSc2(SearchCriteria<T> sc2) {
        this.sc2 = sc2;
    }
    /* (non-Javadoc)
     * @see com.prodyna.esd.filesystem.filemanager.search.SearchCriteria#matches(java.lang.Object)
     */
    @Override
    public boolean matches(T element) {
        return sc1.matches(element)||sc2.matches(element);
    }
}
