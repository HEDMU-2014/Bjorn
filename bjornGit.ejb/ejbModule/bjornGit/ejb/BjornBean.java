package bjornGit.ejb;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class BjornBean
 */
@Stateful
public class BjornBean implements BjornBeanRemote, BjornBeanLocal {


	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
