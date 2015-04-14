package by.kanchanin.publications;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomData;
import org.apache.commons.math3.random.RandomDataImpl;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.kanchanin.publications.datamodel.Comment;
import by.kanchanin.publications.datamodel.Company;
import by.kanchanin.publications.datamodel.OrderResult;
import by.kanchanin.publications.datamodel.Payment;
import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.datamodel.ShoppingCart;
import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.datamodel.UserProfile;
import by.kanchanin.publications.datamodel.enums.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public abstract class AbstractServiceTest {
	
	private final static Random random = new Random();
	protected static final RandomData RANDOM_DATA = new RandomDataImpl();

	private static final int RANDOM_STRING_SIZE = 8;

	public static String randomString() {
		return RandomStringUtils.randomAlphabetic(RANDOM_STRING_SIZE);
	}

	public static String randomString(final String prefix) {
		return String.format("%s-%s", new Object[] { prefix, randomString() });
	}

	public static int randomTestObjectsCount() {
		return RANDOM_DATA.nextInt(0, 5) + 1;
	}

	public static int randomInteger() {
		return randomInteger(0, 9999);
	}

	public static int randomInteger(final int lower, final int upper) {
		return RANDOM_DATA.nextInt(lower, upper);
	}

	public static boolean randomBoolean() {
		return Math.random() < 0.5;
	}

	public static long randomLong() {
		return RANDOM_DATA.nextLong(0, 9999999);
	}

	public static BigDecimal randomBigDecimal() {
		return new BigDecimal(randomDouble()).setScale(2, RoundingMode.HALF_UP);
	}

	public static double randomDouble() {
		final double value = random.nextDouble() + randomInteger();
		return Math.round(value * 1e2) / 1e2;

	}

	public static <T> T randomFromCollection(final Collection<T> all) {
		final int size = all.size();
		final int item = new Random().nextInt(size); // In real life, the Random
														// object should be
														// rather more shared
														// than this
		int i = 0;
		for (final T obj : all) {
			if (i == item) {
				return obj;
			}
			i = i + 1;
		}
		return null;
	}

	public static Date randomDate() {
		final int year = randBetween(1900, 2010);
		final GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, year);
		final int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return gc.getTime();
	}

	public static int randBetween(final int start, final int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	protected UserAccount createUserAccount() {
        final UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(randomString("firstName-"));
        userAccount.setLastName(randomString("lastName-"));
        userAccount.setEmail(randomString("email-"));
        userAccount.setPassword(randomString("password"));
        return userAccount;
    }

    protected UserProfile createUserProfile() {
        final UserProfile userProfile = new UserProfile();
        userProfile.setAdress(randomString("adress-"));
        userProfile.setTelefone(randomLong());
        userProfile.setCreditCard(randomLong());
        userProfile.setCreated(randomDate());
        userProfile.setRole(UserRole.userrole_administrator);
        userProfile.setRole(UserRole.userrole_client);
        return userProfile;
    }

    protected Periodical createPeriodical() {
    	Periodical periodical = new Periodical();
    	periodical.setTitle(randomString("title-"));
    	periodical.setPerType(randomString("type-"));
    	periodical.setDateOfIssue(randomDate());
    	periodical.setPrice(randomBigDecimal());
    	periodical.setAvailable(randomBoolean());
        return periodical;
    }
    
    protected Payment createPayment() {
    	Payment payment = new Payment ();
    	payment.setDateOfPayment(randomDate());
    	return payment;
    	
    }
    
    protected ShoppingCart createShopingCart () {
    	ShoppingCart shoppingCart = new ShoppingCart();
    	return shoppingCart;	
    }
    
    protected OrderResult createOrderResult (){
    	OrderResult orderResult = new OrderResult();
    	orderResult.setStatus(OrderStatus.orderstatus_succeeded);
    	orderResult.setStatus(OrderStatus.orderstatus_failed);
    	return orderResult;
    }
    
    protected Company createCompany() {
    	Company company = new Company();
    	company.setCompanyName(randomString("name-"));
    	return company;
    }
    
    protected Comment createComment (){
    	Comment comment = new Comment();
    	comment.setComment(randomString("text-"));
    	comment.setDateOfComment(randomDate());
    	return comment;
    }
    
}

