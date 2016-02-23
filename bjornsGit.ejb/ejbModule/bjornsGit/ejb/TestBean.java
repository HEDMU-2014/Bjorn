package bjornsGit.ejb;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class TestBean
 */
@Stateful
public class TestBean implements TestBeanRemote, TestBeanLocal {

    /**
     * Default constructor. 
     */
    public TestBean() {
        // TODO Auto-generated constructor stub
    }

}
