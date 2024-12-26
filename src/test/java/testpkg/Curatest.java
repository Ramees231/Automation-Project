package testpkg;
import org.testng.annotations.Test;
import basepgm.Curabase;
import pagepkg.Curapage;

	public class Curatest extends Curabase{
		@Test
		public void test() throws InterruptedException {
		 Curapage ob=new Curapage(driver);
			ob.click();
			ob.switchToNewWindow();
			ob.copyPaste();
			ob.appointment();
			ob.datePick("January 2025","23");
			ob.comnt("hey helloo");
		}

	}

