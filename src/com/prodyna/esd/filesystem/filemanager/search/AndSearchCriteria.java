package com.prodyna.esd.filesystem.filemanager.search;

<<<<<<< HEAD
public class AndSearchCriteria<T> implements SearchCriteria<T>{
    
    /**
     * @return the sc1
     */
    public SearchCriteria<T> getSc1() {
        return sc1;
    }
    /**
     * @param sc1 the sc1 to set
     */
    public void setSc1(SearchCriteria<T> sc1) {
        this.sc1 = sc1;
    }
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
    /**
     * @param sc1
     * @param sc2
     */
    public AndSearchCriteria(SearchCriteria<T> sc1, SearchCriteria<T> sc2) {
        super();
        this.sc1 = sc1;
        this.sc2 = sc2;
    }
    private SearchCriteria<T> sc1;
    private SearchCriteria<T> sc2;
    /* (non-Javadoc)
     * @see com.prodyna.esd.filesystem.filemanager.search.SearchCriteria<T>#matches(java.lang.Object)
     */
    @Override
    public boolean matches(T element) {
        return sc1.matches(element)&&sc2.matches(element);
    }
=======
/**
 * 
 * @author jtrumpfheller
 *
 */
public class AndSearchCriteria {
>>>>>>> e6583178ceb3f1f312b215f6ead64337502071e8

}
