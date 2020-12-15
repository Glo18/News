package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralNewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesGeneralNewsDetails() throws Exception{
        GeneralNews testGeneralNews = setUpGeneralNews();
        assertEquals("TeamWork", testGeneralNews.getTitle());
        assertEquals("GoodWork", testGeneralNews.getNews());
        assertEquals("Glory", testGeneralNews.getAuthor());
    }

    @Test
    public void setId(){
        GeneralNews testGeneralNews = setUpGeneralNews();
        testGeneralNews.setId(4);
        assertEquals(4,testGeneralNews.getId());
    }

    //    helper
    public GeneralNews setUpGeneralNews(){
        return new GeneralNews("TeamWork", "GoodWork", "Glory");
    }
}