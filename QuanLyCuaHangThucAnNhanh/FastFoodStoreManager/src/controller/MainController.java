package controller;

import java.util.Date;

import constant.Rule;
import models.Admin;
import models.Center;
import models.PersonObserver;
import models.ProductObserver;
import models.Subject;
import models.product.beverage.CarbonateSoftDrink;
import models.product.beverage.Juice;
import models.product.beverage.Mixed;
import models.product.beverage.Tea;
import models.product.food.BurgerBeef;
import models.product.food.BurgerCheese;
import models.product.food.BurgerChicken;
import models.product.food.BurgerFish;
import models.product.food.BurgerShrimp;
import models.product.food.FrenchFries;
import models.product.food.FriedChicken;
import models.product.food.Spagetti;
import views.MainView;

public class MainController {
	private Subject center;

	public void initProduct() {
		ProductObserver burgerBeef = new BurgerBeef("Burger Bò", 10, 1.3, "../FastFoodStoreManager/img/burgerBeef.png",
				center);
		ProductObserver burgerChicken = new BurgerChicken("Burger Gà", 10, 1.06,
				"../FastFoodStoreManager/img/burgerChicken.png", center);
		ProductObserver burgerCheese = new BurgerCheese("Burger phô mai", 10, 1.06,
				"../FastFoodStoreManager/img/burgerCheese.png", center);
		ProductObserver spaghetti = new Spagetti("Mì Spaghetti", 10, 1.48, "../FastFoodStoreManager/img/spaghetti.png",
				center);
		ProductObserver friedChicken = new FriedChicken("Gà rán", 10, 1.3,
				"../FastFoodStoreManager/img/friedChicken.png", center);
		ProductObserver friedFrench = new FrenchFries("Khoai tây chiên", 10, 0.63,
				"../FastFoodStoreManager/img/chips.png", center);
		ProductObserver burgurShrimp = new BurgerShrimp("Burger Tôm", 10, 1.06,
				"../FastFoodStoreManager/img/burgerShrimp.png", center);
		ProductObserver burgerFish = new BurgerFish("Burger cá", 10, 0.85, "../FastFoodStoreManager/img/burgerFish.png",
				center);
		ProductObserver carbonateSoftDrink = new CarbonateSoftDrink("Nước giải khát có gas", 10, 0.42,
				"../FastFoodStoreManager/img/carbonateSoftDrink.png", center);
		ProductObserver juice = new Juice("Nước ép trái cây", 10, 0.63, "../FastFoodStoreManager/img/juice.png",
				center);
		ProductObserver mixedStrawberry = new Mixed("Mixed: Orange Power!", 10, 0.85,
				"../FastFoodStoreManager/img/mixedStrawberry.png", center);
		ProductObserver mixedCherry = new Mixed("Mixe: Blue!", 10, 0.85, "../FastFoodStoreManager/img/mixedCherry.png",
				center);
		ProductObserver mixedDragonFruit = new Mixed("Mixed: Sweet Pink!", 10, 0.63,
				"../FastFoodStoreManager/img/mixedDragonFruit.png", center);
		ProductObserver mixedGrape = new Mixed("Mixed: Red!", 10, 0.63, "../FastFoodStoreManager/img/mixedGrape.png",
				center);
		ProductObserver mixedLychee = new Mixed("Mixed: White!", 10, 0.63,
				"../FastFoodStoreManager/img/mixedLychee.png", center);
		ProductObserver mixedPeach = new Mixed("Mixed: Bia Đào", 10, 0.85, "../FastFoodStoreManager/img/mixedPeach.png",
				center);
		ProductObserver tea = new Tea("Trà", 10, 0.42, "../FastFoodStoreManager/img/tea.png", center);
		ProductObserver honeyTea = new Tea("Trà mật ong chanh", 10, 0.63, "../FastFoodStoreManager/img/honeyTea.png",
				center);
		ProductObserver gingerTea = new Tea("Trà gừng", 10, 0.42, "../FastFoodStoreManager/img/gingerTea.png", center);
		ProductObserver ginsengTea = new Tea("Trà nhân sâm", 10, 1.3, "../FastFoodStoreManager/img/ginsengTea.png",
				center);
		ProductObserver atisoTea = new Tea("Trà hoa Atiso", 10, 0.63, "../FastFoodStoreManager/img/atisoTea.png",
				center);
		ProductObserver daisyTea = new Tea("Trà hoa cúc", 10, 0.42, "../FastFoodStoreManager/img/daisyTea.png", center);
	}

	public void initEmployee(PersonObserver admin) {
		((Admin) admin).createEmployeecreateEmployee(Rule.Cashier, "098785746778", "Tran Tu Nguyet",
				new Date(2001, 5, 10), new Date(2025, 5, 10), "Female", "Ho Chi Minh", "hoamuoigio2001@gmail.com",
				"0914945738");
		((Admin) admin).createEmployeecreateEmployee(Rule.KitchenStaff, "02232343232", "Tong Truc Phung Tran",
				new Date(2001, 10, 5), new Date(2025, 12, 24), "Famele", "Ho Chi Minh", "phungtran@gmail.com",
				"0888877773");
		((Admin) admin).createEmployeecreateEmployee(Rule.Shipper, "098357483838", "Ngo Cu Van", new Date(2003, 9, 19),
				new Date(2024, 2, 25), "Male", "Binh Duong", "cuvandeptrai@gmail.com", "0533352635");
		((Admin) admin).createEmployeecreateEmployee(Rule.Cashier, "089736263726", "Chau Van Loc", new Date(2001, 5, 5),
				new Date(2023, 9, 21), "Male", "Tay Bac", "thaylocphuho@gmail.com", "0988873662");
		((Admin) admin).createEmployeecreateEmployee(Rule.Cashier, "093829484928", "Cao Mi Le", new Date(2000, 10, 10),
				new Date(2023, 9, 9), "Female", "Gia Lai", "camile@gmai.com", "0363637263");
		((Admin) admin).createEmployeecreateEmployee(Rule.KitchenStaff, "938293829389", "Le Sin", new Date(1999, 9, 20),
				new Date(2024, 12, 31), "Male", "Ninh Thuan", "lesin@gmail.com", "0988888979");
		((Admin) admin).createEmployeecreateEmployee(Rule.KitchenStaff, "098332322332", "Au Tra Son",
				new Date(1998, 12, 12), new Date(2025, 7, 12), "Male", "Ha Noi", "rongthan@gmail.com", "0993332221");
		((Admin) admin).createEmployeecreateEmployee(Rule.KitchenStaff, "092828182888", "Tran Trung Nhat",
				new Date(2002, 6, 30), new Date(2026, 8, 12), "Male", "An Giang", "nhat@gmail.com", "0347474878");
		((Admin) admin).createEmployeecreateEmployee(Rule.KitchenStaff, "022333233232", "Dao My Nhan",
				new Date(2002, 4, 24), new Date(2023, 12, 11), "Female", "Bac Ninh", "daomynhan@gmail.com",
				"0939393929");
		((Admin) admin).createEmployeecreateEmployee(Rule.Shipper, "093938484575", "Phan Duy Manh",
				new Date(1997, 1, 12), new Date(2024, 12, 20), "Male", "Ho Chi Minh", "phaduymanh@gmail.com",
				"0737374747");
		((Admin) admin).createEmployeecreateEmployee(Rule.Shipper, "099988777666", "Ha Thi Thu Uyen",
				new Date(2001, 7, 27), new Date(2023, 12, 24), "Female", "Ha Tinh", "uyen@gmail.com", "0999888991");
	}

	public void initCustomer() {
		center.register("Pham Huy Hoang", "0812838212", "huyhoang@gamil.com", "huyhoang");
		center.register("To Thi Thao", "0942323123", "thaocute@gmail.com", "123thaocute");
		center.register("Nguyen Van Teo", "0123456789", "teoem@hotmail.com", "teodeptrai");
		center.register("Le Dau", "0987654321", "dau@gmail.com", "daubanh01");
		center.register("To Hoai", "0234567819", "hoai@gmail.com", "hoainhatho");
		center.register("To Huu", "0876543219", "huucodao@gmail.com", "huunhavan");
		center.register("Ho Xuan Huong", "0765432198", "nuchuacakhia@gmail.com", "yolo1010");
		center.register("Xuan Dieu", "0543219876", "dieudiudang@gmail.com", "1056821bc");
		center.register("Lam Thi Hoai Thuong", "0432199765", "thuongnhoai@gmail.com", "o92831");
		center.register("Ma Nhat Huu", "0123556689", "123hudaica@gmail.com", "7483jdkk");
		center.register("Banh Thi My Dieu", "088774321", "dieuhienthuc@gmail.com", "diuhienlanh");
		center.register("Tran Thanh Tu", "0987654312", "tranthanhtu@gmail.com", "tu123456");
		center.register("Dac Ki", "0123466779", "hoyeu@gmail.com", "12kkj12");
		center.register("Khuong Tu Nha", "012998874", "nhatiensinh@gmail.com", "phongkas");
		center.register("Tan Hoang Nhi", "0453631345", "nhinhi@gmail.com", "7682d");
		center.register("Uyen Nhi Lam", "0383946175", "uyennhi@gmail.com", "2jjfh");
		center.register("Truong Uyen", "0378263781", "uyenquadeptrai@gmail.com", "timenhemiu");
		center.register("Ti Menh", "0378882936", "menhdaiti@gmail.com", "vanmenhcuatalauyenca");
		center.register("Cuu Van Hoa", "0874646473", "hoa@gmail.com", "73hduoicato");
		center.register("Truong Y", "099983876", "yeuhoa@gmail.com", "yeuhoanhieulam");
		center.register("Huong Ly Nguyet", "0356726374", "nguyetly@gmail.com", "hksa33");

	}

	public void init() {
		center = Center.getInstance();
		PersonObserver ad1 = new Admin("ChauVanLoc", "0346128692", "locchau.220401@gmail.com", "chauvanloc", center);
		MainView mainView = new MainView(center);
		initEmployee((Admin) ad1);
		initCustomer();
		initProduct();
		mainView.display();
	}

	public static void main(String[] args) {
		MainController main = new MainController();
		main.init();
	}
}