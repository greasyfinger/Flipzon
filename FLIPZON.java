import java.util.*;

public class FLIPZON {
    static Scanner load = new Scanner(System.in);
    static Random mf = new Random();

    interface terminal {

        public static void browse() {
            while (true) {
                Odmin.catshow();
                if (Odmin.categories.size() == 1) {
                    System.out.println("No Products yet ");
                    return;
                }
                System.out.print("Enter Category ID to explore( or 0 to go return) : ");
                int procure = load.nextInt();
                load.nextLine();
                if (procure != 0) {
                    Category gg_great_trick = Odmin.categories.stream().filter(iknow -> procure == iknow.getid())
                            .findFirst().orElse(null);
                    while (true) {
                        Odmin.whichOne(gg_great_trick);
                        System.out.print("Enter Product ID to explore (or 0 to go back) : ");
                        int noProcure = load.nextInt();
                        load.nextLine();
                        if (noProcure != 0) {
                            Product adam = gg_great_trick.produce.stream()
                                    .filter(whoknows -> noProcure == whoknows.getid()).findFirst().orElse(null);
                            adam.prInfo();
                            System.out.print("Enter 0 to go back : ");
                            load.nextLine();
                        } else
                            break;
                    }
                } else
                    return;
            }

        }

        public static void initial() {
            Odmin.whoTheAdmin();
            menuPrint(0);
        }

        public static void menuPrint(int num) {
            if (num == 0) {
                while (true) {
                    System.out.println("Welcome to FLIPZON");
                    System.out.println("    1) Enter as Admin");
                    System.out.println("    2) Explore the Product Catalog");
                    System.out.println("    3) Show Available Deals");
                    System.out.println("    4) Enter as Customer");
                    System.out.println("    5) Exit the Application");
                    System.out.print("index input : ");
                    int cinep = load.nextInt();
                    load.nextLine();
                    if (cinep == 1) {
                        menuPrint(1);
                    } else if (cinep == 2) {
                        browse();
                    } else if (cinep == 3) {
                        Odmin.dealShaw();
                    } else if (cinep == 4) {
                        menuPrint(2);
                    } else
                        return;
                }
            } else if (num == 1) {
                Admin sog = Odmin.logIn();
                if (sog != null) {
                    while (true) {
                        System.out.println("Choose one of the following options :-");
                        System.out.println("    1) Add category ");
                        System.out.println("    2) Delete category");
                        System.out.println("    3) Add Product");
                        System.out.println("    4) Delete Product");
                        System.out.println("    5) Set Discount on Product");
                        System.out.println("    6) Add giveaway deal");
                        System.out.println("    7) Back");
                        System.out.print("index input : ");
                        int sinep = load.nextInt();
                        load.nextLine();
                        if (sinep == 1) {
                            sog.addCat();
                        } else if (sinep == 2) {
                            sog.deleteCat();
                        } else if (sinep == 3) {
                            sog.addProd();
                        } else if (sinep == 4) {
                            sog.deleteProd();
                        } else if (sinep == 5) {
                            sog.dicooot();
                        } else if (sinep == 6) {
                            sog.giveAway();
                        } else
                            return;
                    }

                }
                return;
            } else if (num == 2) {
                while (true) {
                    System.out.println("Sign Up of Log In");
                    System.out.println("    1) Sign up");
                    System.out.println("    2) Log in");
                    System.out.println("    3) Back");
                    System.out.print("index input :");
                    int snnep = load.nextInt();
                    load.nextLine();
                    if (snnep == 1) {
                        goodmanMaadCompany.signup();
                    } else if (snnep == 2) {
                        menuPrint(3);
                    } else
                        return;
                }
            } else if (num == 3) {
                Customer kys = goodmanMaadCompany.logIn();
                if (kys == null)
                    return;
                while (true) {
                    System.out.println("Welcome Cusotmer");
                    System.out.println("    1) browse products");
                    System.out.println("    2) browse deals");
                    System.out.println("    3) add a product to cart");
                    System.out.println("    4) add products in deal to cart");
                    System.out.println("    5) view coupons");
                    System.out.println("    6) check account balance");
                    System.out.println("    7) view cart");
                    System.out.println("    8) empty cart");
                    System.out.println("    9) checkout cart");
                    System.out.println("    10) upgrade customer status");
                    System.out.println("    11) Add amount to wallet");
                    System.out.println("    12)back");

                    System.out.print("index input :");
                    int pcnep = load.nextInt();
                    load.nextLine();
                    if (pcnep == 3) {
                        kys.carter(Odmin.adminList.get(0));
                    } else if (pcnep == 4) {
                        kys.dealCarter(Odmin.adminList.get(0));
                    } else if (pcnep == 5) {
                        kys.canopy();
                    } else if (pcnep == 6) {
                        kys.getWallet();
                    } else if (pcnep == 7) {
                        kys.veiwCarter();
                    } else if (pcnep == 8) {
                        kys.emptier();
                    } else if (pcnep == 9) {
                        kys.payer();
                    } else if (pcnep == 1) {
                        kys.explore();
                    } else if (pcnep == 2) {
                        kys.ShawnDeal();
                    } else if (pcnep == 10) {
                        kys.upgrade();
                        System.out.print("Enter 1 to log out : ");
                        if (load.nextInt() == 1) {
                            load.nextLine();
                            System.out.println("Loggin out");
                            return;
                        }
                        load.nextLine();
                    } else if (pcnep == 11) {
                        kys.setWallet();
                    } else
                        return;
                }
            }
        }
    }

    public boolean cronychk(Customer victim, Double val) {

        if (victim.wallet < val) {
            return false;
        }
        return true;

    }

    interface Odmin {

        static ArrayList<Admin> adminList = new ArrayList<>();
        static ArrayList<Category> categories = new ArrayList<>();

        public static Admin logIn() {
            System.out.print("Enter username : ");
            String who = load.nextLine();
            Admin ad_min = adminList.stream().filter(dont -> who.compareTo(dont.getUid()) == 0).findFirst()
                    .orElse(null);
            if (ad_min != null) {
                int tri = 2;
                while (tri != 0) {
                    System.out.print("Enter Passcode : ");
                    int fr = load.nextInt();
                    load.nextLine();
                    if (fr == ad_min.getRollNo()) {
                        System.out.println("admin access granted");
                        System.out.println("Welcome " + who);
                        return ad_min;
                    }
                    tri -= 1;
                    System.out.println(tri + " try left!");
                }
                System.out.println("admin access denied");
                return null;
            }
            System.out.println("invalid username");
            return null;

        }

        public static void whichOne(Category youKnow) {
            youKnow.getProduce();
            return;
        }

        public static void whoTheAdmin() {

            adminList.add(new Admin("Gus Fring", 211));
            adminList.add(new Admin("Saul Goodman", 208));
            categories.add(new Category(-1, "giveAway"));
        }

        public static void catshow() {
            for (int i = 1; i < categories.size(); i++) {
                System.out.println(categories.get(i).getid() + "  " + categories.get(i).getName());
            }
        }

        public static void dealShaw() {
            Category tubig = categories.get(0);
            tubig.getDeal(adminList.get(0));
        }

        public void addCat();

        public void deleteCat();

        public void addProd();

        public void deleteProd();

        public void dicooot();

        public void giveAway();

    }

    public static class Admin implements Odmin {

        private String uid;

        private int rollNo;

        public int getRollNo() {
            return rollNo;
        }

        public String getUid() {
            return uid;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        Admin(String walter, int jesse) {
            this.uid = walter;
            this.rollNo = jesse;
        }

        @Override
        public void addCat() {
            System.out.print("Enter Category ID : ");
            int gm = load.nextInt();
            Category gg_bye = categories.stream().filter(idontknow -> gm == idontknow.getid()).findFirst()
                    .orElse(null);
            if (gg_bye != null) {
                System.out.println("Category exisits");
                System.out.println();
                return;
            }
            load.nextLine();
            System.out.print("Enter Category name : ");
            String champ = load.nextLine();
            System.out.print("How many Products to enter : ");
            int strngr = load.nextInt();
            load.nextLine();
            if (strngr == 0) {
                System.out.println("Category deleted, can't have no products");
                return;
            }
            Category sinister = new Category(gm, champ);
            categories.add(sinister);
            while (strngr != 0) {
                System.out.println("Enter Product Details");
                System.out.print("Enter Name          : ");
                String wo = load.nextLine();
                System.out.print("Enter  Quantity     : ");
                int muc = load.nextInt();
                load.nextLine();
                System.out.print("Enter Price         : ");
                double cas = load.nextDouble();
                load.nextLine();
                new Product(wo, muc, sinister, cas);
                System.out.println("Product Added");
                System.out.println();
                strngr -= 1;

            }

        }

        @Override
        public void deleteCat() {
            System.out.print("Enter Category ID  : ");
            int jiD = load.nextInt();
            load.nextLine();
            Category gg_bye = categories.stream().filter(idontknow -> jiD == idontknow.getid()).findFirst()
                    .orElse(null);
            if (gg_bye == null) {
                System.out.println("No Category found");
                return;
            }
            gg_bye.produce.clear();
            categories.remove(gg_bye);
            System.out.println("Category Removed");
            return;

        }

        @Override
        public void addProd() {
            System.out.print("Enter Category ID  : ");
            int jiD = load.nextInt();
            load.nextLine();
            Category gg_hi = categories.stream().filter(idontknow -> jiD == idontknow.getid()).findFirst()
                    .orElse(null);
            if (gg_hi == null) {
                System.out.println("No Category found");
                System.out.println("Creating a new Category...");
                addCat();
                return;
            }
            System.out.print("How many Products to enter : ");
            int wower = load.nextInt();
            load.nextLine();
            while (wower != 0) {
                System.out.println("Enter Product Details");
                System.out.print("Enter Name          : ");
                String wo = load.nextLine();
                System.out.print("Enter  Quantity     : ");
                int muc = load.nextInt();
                load.nextLine();
                System.out.print("Enter Price         : ");
                double cas = load.nextDouble();
                load.nextLine();
                new Product(wo, muc, gg_hi, cas);
                System.out.println("Product Added");
                System.out.println();
                wower -= 1;

            }
            return;

        }

        @Override
        public void deleteProd() {
            System.out.print("Enter Category ID  : ");
            int jiD = load.nextInt();
            load.nextLine();
            Category gg_ok = categories.stream().filter(idontknow -> jiD == idontknow.getid()).findFirst()
                    .orElse(null);
            if (gg_ok == null) {
                System.out.println("No Category found");
                return;
            } else if (gg_ok.produce.size() == 1) {
                System.out.println("Can't have an empty Category");
                return;
            }
            System.out.print("Enter Product ID  : ");
            int JId = load.nextInt();
            load.nextLine();
            Product gg_enough = gg_ok.produce.stream().filter(iknow -> JId == iknow.getid()).findFirst()
                    .orElse(null);
            if (gg_enough == null) {
                System.out.println("Product Not found");
                return;
            }
            gg_ok.produce.remove(gg_enough);
            return;

        }

        @Override
        public void dicooot() {
            System.out.print("Enter Product ID : ");
            int dig = load.nextInt();
            load.nextLine();
            Product crap = prodfinder(dig);
            System.out
                    .println("Enter discount(in percentage,space seperated for Elite Prime Normal respectively):- ");
            double dicoot = load.nextDouble();
            double dicot = load.nextDouble();
            double dict = load.nextDouble();
            load.nextLine();
            crap.setIntDisc(dicoot, dicot, dict);
            return;
        }

        public Product prodfinder(int JId) {
            int jiD = JId / 1000;
            Category gg_plox = categories.stream().filter(idontknow -> jiD == idontknow.getid()).findFirst()
                    .orElse(null);
            if (gg_plox == null) {
                System.out.println("Product Not found");
                return null;
            }
            Product gg_sorry = gg_plox.produce.stream().filter(iknow -> JId == iknow.getid()).findFirst()
                    .orElse(null);
            if (gg_sorry == null) {
                System.out.println("Product Not found");
                return null;
            }
            return gg_sorry;

        }

        @Override
        public void giveAway() {
            System.out.print("Enter first Product ID   : ");
            int JId = load.nextInt();
            load.nextLine();
            Product plock1 = prodfinder(JId);
            System.out.print("Enter secound Product ID : ");
            int JiD = load.nextInt();
            load.nextLine();
            Product plock2 = prodfinder(JiD);
            double netter = plock1.price + plock2.price;
            double tummy = 0;
            double tumy = 0;
            double tuy = 0;
            while (true) {
                System.out.println("Enter Combine price (should be less than " + netter + ")");
                tummy = load.nextDouble();
                tumy = load.nextDouble();
                tuy = load.nextDouble();
                load.nextLine();
                if (tuy < netter)
                    break;
                System.out.println("Enter valid price");
            }
            Category compton = categories.get(0);
            int promise = compton.produce.size();
            Product pls_stop = new Product(plock1.uid * -1, "a" + promise, plock2.uid, compton, netter, tummy, tumy,
                    tuy);
            compton.produce.add(pls_stop);
        }

    }

    public static Customer lvlup(int levl, Customer that) {
        if (levl == 1)
            that = new Prime(that, that.getyWallet() - 200);
        else
            that = new Elite(that, that.getyWallet() - 300);
        return that;
    }

    public static Customer lvlup(Prime that) {
        that = new Elite(that, that.getyWallet() - 100);
        return that;
    }

    interface goodmanMaadCompany {

        static ArrayList<Customer> geese = new ArrayList<>();

        public static void signup() {
            System.out.print("Enter your Name     : ");
            String ame = load.nextLine();
            System.out.print("Enter your Age      : ");
            int ge = load.nextInt();
            load.nextLine();
            System.out.print("Enter your Phone    : ");
            long hone = load.nextLong();
            load.nextLine();
            System.out.print("Enter your Email ID : ");
            String mail = load.nextLine();
            String assword = null;
            while (true) {
                System.out.println("Enter passcode");
                assword = load.nextLine();
                System.out.println("Confirm Passcode");
                String firm_asscode = load.nextLine();
                if (assword.compareTo(firm_asscode) == 0)
                    break;
            }
            geese.add(new Customer(ame, ge, hone, assword, mail));
            System.out.println("Account Created !");
            return;

        }

        public static Customer logIn() {
            System.out.print("Enter your Name     : ");
            String ame = load.nextLine();
            System.out.print("Enter your Age      : ");
            int ge = load.nextInt();
            load.nextLine();
            System.out.print("Enter your Email ID : ");
            String mail = load.nextLine();
            Customer hem = geese.stream()
                    .filter(idontknow -> ame.compareTo(idontknow.name) == 0 && ge == idontknow.age
                            && mail.compareTo(idontknow.email) == 0)
                    .findFirst().orElse(null);
            if (hem == null) {
                System.out.println("Enter Valid Cusotmer detail");
                return logIn();
            } else {
                int irt = 2;
                while (irt != 0) {
                    System.out.print("Enter Passcode : ");
                    String passer = load.nextLine();
                    if (hem.password.compareTo(passer) == 0) {
                        System.out.println("Logged in");
                        return hem;
                    }
                    irt -= 1;
                    System.out.println("incorrect passcode. " + irt + " tries left");
                }
                System.out.println("Tries Exhausted");
                return null;
            }
        }

        public void upgrade();

        public void explore();

        public void carter(Admin bluck);

        public void payer();

        public void ShawnDeal();
    }

    public static class Customer implements goodmanMaadCompany {
        protected String name;
        private int age;
        private long phone;
        protected String email;
        private String password;
        protected int lvl;
        protected double wallet;
        protected Date when;
        protected int Delivery;
        protected ArrayList<Product> bill = new ArrayList<>();

        public void setWallet() {
            System.out.println("Enter amount : ");
            this.wallet += load.nextDouble();
            load.nextLine();
        }

        public void getWallet() {
            System.out.println("You have " + this.wallet + " amount left.");
            System.out.println();
        }

        public double getyWallet() {
            return this.wallet;
        }

        public static void osut() {
            for (int i = 0; i < geese.size(); i++) {
                System.out.println(geese.get(i).lvl);
            }
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public Customer(String eman, int ega, long enohp, String drowssap, String liam) {
            this.name = eman;
            this.age = ega;
            this.phone = enohp;
            this.password = drowssap;
            this.lvl = 0;
            this.wallet = 1000;
            this.when = null;
            this.email = liam;
            geese.add(this);
        }

        protected Customer(Customer that) {

            this.name = that.name;
            this.age = that.age;
            this.phone = that.phone;
            this.password = that.password;
            this.email = that.email;

        }

        @Override
        public void upgrade() {
            if (this.wallet < 200) {
                System.out.println("Insufficient Balance to Upgrade");
                System.out.println();
                return;
            }
            System.out.println("Which level would you like to upgrade to :-");
            System.out.println("    1. PRIME");
            System.out.println("    2. ELITE");
            int levelr = load.nextInt();
            load.nextLine();
            if (levelr != 1 && this.wallet < 300) {
                System.out.println("Insufficient Balance to Upgrade");
                System.out.println();
                return;
            }
            int fu = geese.indexOf(this);
            geese.set(fu, lvlup(levelr, this));
            return;
        }

        public void canopy() {

            System.out.println("You Don't have any coupons");
            System.out.println("Upgrade to Prime and ELite to get coupons");
            System.out.println();
        }

        @Override
        public void explore() {
            while (true) {
                Odmin.catshow();
                if (Odmin.categories.size() == 1) {
                    System.out.println("No Products yet ");
                    return;
                }
                System.out.print("Enter Category ID to explore( or 0 to go return) : ");
                int procure = load.nextInt();
                load.nextLine();
                if (procure != 0) {
                    Category gg_great_trick = Odmin.categories.stream().filter(iknow -> procure == iknow.getid())
                            .findFirst().orElse(null);

                    while (true) {
                        Odmin.whichOne(gg_great_trick);
                        System.out.println("Enter Product ID to explore (or 0 to go back) : ");
                        int noProcure = load.nextInt();
                        load.nextLine();
                        if (noProcure != 0) {
                            Product eve = gg_great_trick.produce.stream()
                                    .filter(whoknows -> noProcure == whoknows.getid()).findFirst().orElse(null);
                            eve.prInfo();
                            System.out.print("Enter 1(to add to cart) 0(to go back) : ");
                            int slight = load.nextInt();
                            load.nextLine();
                            if (slight == 1) {
                                Product adam = this.bill.stream().filter(whoknows -> eve.id == whoknows.getid())
                                        .findFirst()
                                        .orElse(null);
                                if (adam == null) {
                                    this.bill.add(new Product(eve, eve.intDiscN));
                                } else {
                                    adam.qtyadd(1);
                                    adam.setPrice(adam.price + eve.getIntDisc(0));
                                }
                                System.out.println("Item added to the cart!");
                                eve.qtyadd(-1);
                            }
                            System.out.println();
                        } else
                            break;
                    }
                } else
                    return;
            }

        }

        public void veiwCarter() {
            System.out.println("Following items are stored in your cart");
            for (int i = 0; i < this.bill.size(); i++) {
                this.bill.get(i).prInfo();
                System.out.println();
            }
        }

        public void emptier() {
            this.bill.clear();
        }

        public void dealCarter(Admin bluck) {
            System.out.print("Enter Index : ");
            int trick = load.nextInt();
            load.nextLine();
            if (Odmin.categories.size() <= trick) {
                System.out.println("No deal present");
                return;
            }
            Product deal = Odmin.categories.get(0).produce.get(trick - 1);
            Product p1 = bluck.prodfinder(deal.getId() * -1);
            Product p2 = bluck.prodfinder(deal.getqty());
            this.bill.add(new Product(p1, deal.intDiscN / 2));
            this.bill.add(new Product(p2, deal.intDiscN / 2));
        }

        @Override
        public void carter(Admin bluck) {
            System.out.print("Enter Product ID : ");
            int ffsff = load.nextInt();
            load.nextLine();
            Product eve = bluck.prodfinder(ffsff);
            if (eve == null) {
                return;
            }
            eve.prInfo();
            System.out.println("Enter 1 to add to cart : ");
            int num = load.nextInt();
            load.nextLine();
            if (num == 1) {
                Product adam = this.bill.stream().filter(whoknows -> eve.id == whoknows.getid()).findFirst()
                        .orElse(null);
                if (adam == null) {
                    this.bill.add(new Product(eve, eve.intDiscN));
                } else {
                    adam.qtyadd(1);
                    adam.setPrice(adam.price + eve.getIntDisc(0));
                }
                System.out.println("Item added to the cart!");
                eve.qtyadd(-1);
            }
            return;
        }

        @Override
        public void payer() {
            double total = 0;
            for (int i = 0; i < this.bill.size(); i++) {
                Product ok = this.bill.get(i);
                total += ok.getPrice();
                System.out.println(ok.name + " : " + ok.getPrice());
            }
            double del = 100 + 0.05 * total;
            System.out.println("Delivery Charges : " + del);
            total += del;
            System.out.println("Total bill : " + del);
            System.out.print("To confirm Payment Enter 1 : ");
            int holes = load.nextInt();
            load.nextLine();
            if (holes != 1) {
                System.out.println("Payment Cancelled");
                return;
            } else if (this.wallet < total) {
                System.out.println("Insufficinet balance");
                return;
            }
            this.bill.clear();
            this.wallet -= total;
            System.out.println("payment successfull");
            System.out.println("Prodcut will be shipped in 7-10 days");
        }

        @Override
        public void ShawnDeal() {
            if (Odmin.categories.get(0).produce.size() == 0) {
                System.out.println("No Deals Yet !");
                return;
            }
            Odmin.dealShaw();
            this.dealCarter(Odmin.adminList.get(1));
        }
    }

    public static class Prime extends Customer {

        private ArrayList<Integer> coupon = new ArrayList<>();

        Prime(Customer clack, double walter) {
            super(clack);
            this.lvl = 1;
            this.when = new Date();
            this.wallet = walter;
        }

        public void canopy() {
            if (this.coupon.size() == 0) {
                System.out.println("You Don't have any coupons");
            }
            System.out.println("you Have the following coupons");
            for (int i = 0; i < this.coupon.size(); i++) {
                System.out.println("1. " + this.coupon.get(i) + "% coupons");
            }
            System.out.println();
        }

        public void dealCarter(Admin bluck) {
            System.out.print("Enter Index : ");
            int trick = load.nextInt();
            load.nextLine();
            Product deal = Odmin.categories.get(0).produce.get(trick - 1);
            Product p1 = bluck.prodfinder(deal.getId() * -1);
            Product p2 = bluck.prodfinder(deal.getqty());
            this.bill.add(new Product(p1, deal.intDiscP / 2));
            this.bill.add(new Product(p2, deal.intDiscP / 2));
        }

        public void upgrade() {
            if (this.wallet < 300) {
                System.out.println("Insufficient Balance to Upgrade");
                System.out.println();
                return;
            }
            System.out.println("Which level would you like to upgrade to :-");
            System.out.println("    1. ELITE");
            int levelr = load.nextInt();
            load.nextLine();
            int fu = geese.indexOf(this);
            geese.set(fu, lvlup(levelr, this));
            return;
        }

        public void carter(Admin bluck) {
            System.out.println("Enter Product ID : ");
            int ffsff = load.nextInt();
            load.nextLine();
            Product eve = bluck.prodfinder(ffsff);
            Product twat = new Product(eve, eve.intDiscP);
            twat.prInfo();
            System.out.println("Enter 1 to add to cart : ");
            int num = load.nextInt();
            load.nextLine();
            if (num == 1) {
                Product adam = this.bill.stream().filter(whoknows -> eve.id == whoknows.getid()).findFirst()
                        .orElse(null);
                if (adam == null) {
                    this.bill.add(twat);
                } else {
                    adam.qtyadd(1);
                    adam.setPrice(adam.price + eve.getIntDisc(1));
                }
                System.out.println("Item added to the cart!");
                eve.qtyadd(-1);
            }
            return;
        }

        public void payer() {
            double total = 0;
            for (int i = 0; i < this.bill.size(); i++) {
                Product ok = this.bill.get(i);
                total += ok.getPrice();
                System.out.println(ok.name + " : " + ok.getPrice());
            }
            if (this.coupon.size() != 0) {
                int tapa = Collections.max(this.coupon);
                total = total - (total * tapa / 100);
                System.out.println(tapa + " % discont coupon applied");
            }
            double del = 100 + 0.02 * total;
            System.out.println("Delivery Charges : " + del);
            total += del;
            System.out.println("Total bill : " + total);
            System.out.println("To confirm Payment Enter 1 : ");
            int holes = load.nextInt();
            load.nextLine();
            if (holes != 1) {
                System.out.println("Payment Cancelled");
                return;
            } else if (this.wallet < total) {
                System.out.println("Insufficinet balance");
                return;
            }
            this.bill.clear();
            this.wallet -= total;
            System.out.println("payment successfull");
            System.out.println("Prodcut will be shipped in 3-6 days");
            if (total >= 5000) {
                int how_many = mf.nextInt(1) + 1;
                System.out.println("You have been awarded " + how_many + " coupons ");
                for (int why = 0; why < how_many; why++) {
                    int well = mf.nextInt(10) + 5;
                    System.out.print(well);
                    this.coupon.add(well);
                }
            }
        }

    }

    public static class Elite extends Prime {

        private ArrayList<Integer> coupon = new ArrayList<>();

        Elite(Customer click, double walter) {
            super(click, walter);
            this.lvl = 2;
            this.when = new Date();
            this.wallet = walter;
        }

        Elite(Prime clack, double walter) {
            super(clack, walter);
            this.lvl = 2;
            this.when = new Date();
            this.wallet = walter;
        }

        public void gifter() {
            Category doom = Odmin.categories.get(mf.nextInt(Odmin.categories.size()));
            Product villain = doom.produce.get(mf.nextInt(doom.produce.size()));
            System.out.println("Congratulations! you have received a free gift as our Elite Customer.");
            villain.prInfo();
            this.bill.add(new Product(villain, 0));
        }

        public void canopy() {
            if (this.coupon.size() == 0) {
                System.out.println("You Don't have any coupons");
            }
            System.out.println("you Have the following coupons");
            for (int i = 0; i < this.coupon.size(); i++) {
                System.out.println("1. " + this.coupon.get(i) + "% coupons");
            }
            System.out.println();
        }

        public void dealCarter(Admin bluck) {
            System.out.print("Enter Index : ");
            int trick = load.nextInt();
            load.nextLine();
            Product deal = Odmin.categories.get(0).produce.get(trick - 1);
            Product p1 = bluck.prodfinder(deal.getId() * -1);
            Product p2 = bluck.prodfinder(deal.getqty());
            this.bill.add(new Product(p1, deal.intDiscE / 2));
            this.bill.add(new Product(p2, deal.intDiscE / 2));
        }

        public void carter(Admin bluck) {
            System.out.println("Enter Product ID : ");
            int ffsff = load.nextInt();
            load.nextLine();
            Product eve = bluck.prodfinder(ffsff);
            eve.prInfo();
            System.out.println("Enter 1 to add to cart : ");
            int num = load.nextInt();
            load.nextLine();
            if (num == 1) {
                Product adam = this.bill.stream().filter(whoknows -> eve.id == whoknows.getid()).findFirst()
                        .orElse(null);
                if (adam == null) {
                    this.bill.add(new Product(eve, eve.intDiscP));
                } else {
                    adam.qtyadd(1);
                    adam.setPrice(adam.price + eve.getIntDisc(2));
                }
                System.out.println("Item added to the cart!");
                eve.qtyadd(-1);
            }
            return;
        }

        public void upgrade() {
            System.out.println("Already and an Elite member");
            System.out.println();
            return;
        }

        public void payer() {
            this.gifter();
            double total = 0;
            for (int i = 0; i < this.bill.size(); i++) {
                Product ok = this.bill.get(i);
                total += ok.getPrice();
                System.out.println(ok.name + " : " + ok.getPrice());
            }
            if (this.coupon.size() != 0) {
                int tapa = Collections.max(this.coupon);
                total = total - (total * tapa / 100);
                System.out.println(tapa + " % discont coupon applied");
            }
            double del = 100;
            System.out.println("Delivery Charges : " + del);
            total += del;
            System.out.println("Total bill : " + total);
            System.out.println("To confirm Payment Enter 1 : ");
            int holes = load.nextInt();
            load.nextLine();
            if (holes != 1) {
                System.out.println("Payment Cancelled");
                return;
            } else if (this.wallet < total) {
                System.out.println("Insufficinet balance");
                return;
            }
            this.bill.clear();
            this.wallet -= total;
            System.out.println("payment successfull");
            System.out.println("Prodcut will be shipped within 2 days");
            if (total >= 5000) {
                int how_many = mf.nextInt(1) + 3;
                System.out.print("You have been awarded " + how_many + " coupons ");
                for (int why = 0; why < how_many; why++) {
                    int well = mf.nextInt(10) + 5;
                    System.out.print(well + "% ");
                    this.coupon.add(well);
                }
            }
            return;
        }
    }

    public static class Product extends Category {

        private static int idcntr = 1;
        private String prold;
        private int uid;
        private double price;
        private int qty;
        private double intDiscN;
        private double intDiscE;
        private double intDiscP;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void qtyadd(int num) {
            this.qty = this.qty + num;
            return;
        }

        public int getqty() {
            return this.qty;
        }

        public int getUid() {
            return this.uid;
        }

        public void prInfo() {
            System.out.println("Name : " + this.prold);
            System.out.println("Price : " + this.price);
            System.out.println("Quantity : " + this.qty);
            System.out.println("ID : " + this.uid);
            return;
        }

        public void prInfo(int twat) {
            System.out.println("Name : " + this.prold);
            System.out.println("Price : " + this.price);
            System.out.println("Quantity : " + this.qty);
            int prid = this.uid * -1;
            System.out.println("ID : " + prid);
            return;
        }

        public double getIntDisc(int num) {
            if (num == 0)
                return intDiscN;
            else if (num == 1)
                return intDiscP;
            else
                return intDiscE;
        }

        public void setIntDisc(double intDiscN, double intDiscP, double intDiscE) {
            double adfsdf = this.price - (this.price * intDiscN / 100);
            this.intDiscN = adfsdf < this.intDiscN ? adfsdf : this.intDiscN;
            double adssd = this.price - (this.price * intDiscP / 100);
            this.intDiscP = adssd < this.intDiscP ? adssd : this.intDiscP;
            double adffs = this.price - (this.price * intDiscE / 100);
            this.intDiscE = adffs < this.intDiscE ? adffs : this.intDiscE;
        }

        public Product(String seeaut, int calm, Category encore, double sez) {

            super(encore.id, encore.name);
            this.prold = seeaut;
            this.uid = idcntr + 1000 * this.id;
            this.price = sez;
            this.qty = calm;
            this.intDiscN = sez;
            this.intDiscE = sez - (sez * 10 / 100);
            this.intDiscP = sez - (sez * 5 / 100);
            encore.dragon(this);
            System.out.println("Product ID : " + this.uid);
            Product.idcntr += 1;

        }

        public Product(int real, String seeaut, int calm, Category encore, double sez) {

            super(encore.id, encore.name);
            this.prold = seeaut;
            this.uid = real;
            this.price = sez;
            this.qty = calm;
            encore.dragon(this);

        }

        public Product(int real, String seeaut, int calm, Category encore, double sez, double a, double b, double c) {

            super(encore.id, encore.name);
            this.prold = seeaut;
            this.uid = real;
            this.price = sez;
            this.qty = calm;
            this.setIntDisc(a, b, c);
            encore.dragon(this);

        }

        public Product(Product apple, double price) {

            super(apple.id, apple.name);
            this.prold = apple.prold;
            this.uid = apple.uid;
            this.price = price;
            this.qty = 1;
        }

        public boolean equals(Product that) {
            if (this.uid == that.uid)
                return true;
            else
                return false;
        }

        public int getid() {
            return this.uid;
        }
    }

    static class Category {
        protected int id;
        protected String name;
        private ArrayList<Product> produce = new ArrayList<>();

        public Category(int greasy, String finger) {
            this.id = greasy;
            this.name = finger;
        }

        public boolean equals(Category that) {
            if (this.id == that.id)
                return true;
            else
                return false;
        }

        public void dragon(Product meth) {
            produce.add(meth);
            return;
        }

        public int getid() {
            return this.id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void getProduce() {
            for (int i = 0; i < this.produce.size(); i++) {
                System.out.println(this.produce.get(i).uid + "  " + this.produce.get(i).prold);
            }
            return;
        }

        public void getDeal(Admin whomsoever) {
            int tot = this.produce.size();
            if (tot == 0) {
                System.out.println("No deals at the moment!");
                return;
            }
            System.out.println(tot - 1 + " combo deals available");
            for (int i = 0; i < tot; i++) {
                Product imposter = this.produce.get(i);
                Product jigga = whomsoever.prodfinder(imposter.getUid() * -1);
                Product bigga = whomsoever.prodfinder(imposter.getqty());
                int idkbruh = i + 1;
                System.out.println("Deal - " + idkbruh);
                jigga.prInfo();
                bigga.prInfo();
                System.out.println();
                System.out.println("Combined price : " + imposter.intDiscN);
                System.out.println("Combined price for Prime Customers : " + imposter.intDiscP);
                System.out.println("Combined price for Elite Customers : " + imposter.intDiscE);
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        terminal.initial();
    }

}