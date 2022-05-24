package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Aims {
	
	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("------------------------------");
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	private static void updateStoreMenu() {
		System.out.println("Do you want to add or remove a DVD ?");
		System.out.println("------------------------------");
		System.out.println("1. Add a DVD to store");
		System.out.println("2. Remove a DVD from store");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void yesNoMenu() {
		System.out.println("Do you want to add this DVD to cart ?");
		System.out.println("------------------------------");
		System.out.println("1. Yes");
		System.out.println("0. No");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	private static void removeDVDMenu() {
		System.out.println("Do you want remove a DVD by id or title ?");
		System.out.println("------------------------------");
		System.out.println("1. Remove by id");
		System.out.println("2. Remove by title");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-2");
	}
	
	private static void removeOneOrAll() {
		System.out.println("Do you want remove one or all matching DVDs ?");
		System.out.println("------------------------------");
		System.out.println("1. Remove one matching DVD");
		System.out.println("2. Remove all matching DVDS");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-2");
	}
	
	private static void filterDVDsMenu() {
		System.out.println("Do you want to filter DVDs by id or by title ?");
		System.out.println("------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void sortDVDsMenu() {
		System.out.println("Do you want to sort the cart by id or by title ?");
		System.out.println("------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void main(String[] args) {
		
		//Create a new cart
		Cart userCart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Amimation", "Roger Allers", 87, 19.95f);
		//cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		//cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Amimation", 18.99f);
		//cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("End Game");
		
		//print total cost of the items in the cart
		//System.out.println("Total Cost is: " + cart.totalCost());
		
		//Remove dvds from cart
		//cart.removeDigitalVideoDisc(dvd1);
		//cart.removeDigitalVideoDisc(dvd4);
		
		//add a list of dvds to the cart
		//DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4};
		//cart.addDigitalVideoDisc(dvdList);
		
		//Create a store
		Store store = new Store();
		store.addDVD(dvd1, dvd2, dvd3, dvd4);
		Scanner myScanner = new Scanner(System.in);
		
		while (true) {
			showMenu();
			String showMenuCommand = myScanner.nextLine();
			
			if (showMenuCommand.equals("1")) {
				
				while (true) {
					storeMenu();
					String storeMenuCommand = myScanner.nextLine();
					
					if (storeMenuCommand.equals("1")) {
						System.out.println("Please enter the title of the DVD");
						String dvdTitle = myScanner.nextLine();
						
						//check the validity of title
						ArrayList<DigitalVideoDisc> dvds = store.searchByTitle(dvdTitle);
						if (dvds.size() != 0) {
							for (DigitalVideoDisc dvd: dvds) {
								System.out.println("The infomation of DVD with this title:");
								System.out.print(dvd);
								
								while (true) {
									yesNoMenu();
									String yesNoCommand = myScanner.nextLine();
									
									if (yesNoCommand.equals("1")) {
										userCart.addDigitalVideoDisc(dvd);
										break;
									} else if (yesNoCommand.equals("0")) {
										break;
									} else {
										System.out.println("Wrong command, try again !");
									}
								}
							}
						}
					} else if (storeMenuCommand.equals("2")) {
						System.out.println("------------------------------");
						System.out.println("The infomation about DVDs in store:");
						store.displayDVDs();
						System.out.println("------------------------------");
						System.out.println("Please enter the title of the DVD");
						String dvdTitle = myScanner.nextLine();
						ArrayList<DigitalVideoDisc> dvds = store.searchByTitle(dvdTitle);
						
						if (dvds.size() != 0) {
							for (DigitalVideoDisc dvd: dvds) {
								userCart.addDigitalVideoDisc(dvd);
								System.out.println("The infomation about DVD with this title:");
								System.out.println(dvd);
							}
						}
					} else if (storeMenuCommand.equals("3")) {
						userCart.print();
					} else if (storeMenuCommand.equals("0")) {
						break;
					} else {
						System.out.println("Wrong command, try again !");
					}
				}
			} else if (showMenuCommand.equals("2")) {
				
				while (true) {
					updateStoreMenu();
					String addRemoveCommand = myScanner.nextLine();
					
					if (addRemoveCommand.equals("1")) {
						System.out.println("Please enter the infomation of DVD");
						
						System.out.println("Please enter the title of DVD, press 0 to pass over");
						String title = myScanner.nextLine();
						
						System.out.println("Please enter the category of DVD, press 0 to pass over");
						String category = myScanner.nextLine();
						
						System.out.println("Please enter the director of DVD, press 0 to pass over");
						String director = myScanner.nextLine();
						
						System.out.println("Please enter the length of DVD, press 0 to pass over");
						int length = Integer.parseInt(myScanner.nextLine());
						
						System.out.println("Please enter the cost of DVD, press 0 to pass over");
						float cost = Float.parseFloat(myScanner.nextLine());
						
						store.addDVD(new DigitalVideoDisc(title, category, director, length, cost));
					} else if (addRemoveCommand.equals("2")) {
						System.out.println("------------------------------");
						System.out.println("The infomation about DVDs in store:");
						store.displayDVDs();
						System.out.println("------------------------------");
						
						while (true) {
							//When a DVD is removed from store, it will be also removed from userCart
							System.out.println("------------------------------");
							System.out.println("The infomation about DVDs in store:");
							store.displayDVDs();
							System.out.println("------------------------------");
							removeDVDMenu();
							String removeCommand = myScanner.nextLine();
							
							if (removeCommand.equals("1")) {
								System.out.println("Please enter the id of DVD");
								int id = myScanner.nextInt();
								myScanner.nextLine();
								DigitalVideoDisc dvd = store.searchById(id);
								
								if (dvd != null) {
									store.removeDVD(dvd);
									userCart.removeDigitalVideoDisc(dvd);
								}
							} else if (removeCommand.equals("2")) {
								System.out.println("Please enter the title of DVD");
								String title = myScanner.nextLine();
								ArrayList<DigitalVideoDisc> dvds = store.searchByTitle(title);
								
								if (dvds.size() != 0) {
									while (true) {
										removeOneOrAll();
										String oneOrAllCommand = myScanner.nextLine();
										
										if (oneOrAllCommand.equals("1")) {
											store.removeDVD(dvds.get(0));
											userCart.removeDigitalVideoDisc(dvds.get(0));
											break;
										} else if (oneOrAllCommand.equals("2")) {
											for (DigitalVideoDisc dvd: dvds) {
												store.removeDVD(dvd);
												userCart.removeDigitalVideoDisc(dvd);
											}
											break;
										} else if (oneOrAllCommand.equals("0")) {
											break;
										} else {
											System.out.println("Wrong command, try again !");
										}
									}
								}
							} else if (removeCommand.equals("0")) {
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}

					} else if (addRemoveCommand.equals("0")) {
						break;
					} else {
						System.out.println("Wrong command, try again !");
					}
				} 
			} else if (showMenuCommand.equals("3")) {
				userCart.print();
				
				while (true) {
					cartMenu();
					String cartMenuCommand = myScanner.nextLine();
					
					if (cartMenuCommand.equals("1")) {
						
						while (true) {
							filterDVDsMenu();
							String filteringCommand = myScanner.nextLine();
							
							if (filteringCommand.equals("1")) {
								System.out.println("Please enter the id of DVD");
								int id = myScanner.nextInt();
								myScanner.nextLine();
								DigitalVideoDisc dvd = userCart.searchById(id);
								
								if (dvd != null) {
									System.out.println(dvd);
								}
							} else if (filteringCommand.equals("2")) {
								System.out.println("Please enter the title of DVD");
								String title = myScanner.nextLine();
								ArrayList<DigitalVideoDisc> dvds = userCart.searchByTitle(title);
								
								if (dvds.size() != 0) {
									for (DigitalVideoDisc dvd: dvds) {
										System.out.println(dvd);
									}
								}
							} else if (filteringCommand.equals("0")) {
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}
					} else if (cartMenuCommand.equals("2")) {
						
						while (true) {
							sortDVDsMenu();
							String sortingCommand = myScanner.nextLine();

							if (sortingCommand.equals("1")) {
								ArrayList<DigitalVideoDisc> cart = new ArrayList<DigitalVideoDisc>();
								
								for (int i = 0; i < Cart.MAX_NUMBERS_ORDERED; i++) {
									if (userCart.getItemOrdered()[i] != null) {
										cart.add(userCart.getItemOrdered()[i]);
									}
								}
									
								DigitalVideoDisc[] sortedCart = cart.toArray(new DigitalVideoDisc[cart.size()]);
								sortedCart = DVDUtils.sortByCost(sortedCart);
								sortedCart = DVDUtils.sortByTitle(sortedCart);
								
								System.out.println("********************CART********************");
								System.out.println("Ordered Items:");
								System.out.println(sortedCart.length);
								
								for (int j = 0; j < sortedCart.length; j++) {
									System.out.println(j + 1 + ". DVD - " + sortedCart[j]);
								}
								
								//System.out.println("Total cost: " + this.totalCost() + " $");
								System.out.println("********************************************");
	
							} else if (sortingCommand.equals("2")) {
								ArrayList<DigitalVideoDisc> cart = new ArrayList<DigitalVideoDisc>();
								
								for (int i = 0; i < Cart.MAX_NUMBERS_ORDERED; i++) {
									if (userCart.getItemOrdered()[i] != null) {
										cart.add(userCart.getItemOrdered()[i]);
									}
								}
									
								DigitalVideoDisc[] sortedCart = cart.toArray(new DigitalVideoDisc[cart.size()]);
								sortedCart = DVDUtils.sortByTitle(sortedCart);
								sortedCart = DVDUtils.sortByCost(sortedCart);
								
								System.out.println("********************CART********************");
								System.out.println("Ordered Items:");
								
								for (int j = 0; j < sortedCart.length; j++) {
									System.out.println(j + 1 + ". DVD - " + sortedCart[j]);
								}
								
								//System.out.println("Total cost: " + this.totalCost() + " $");
								System.out.println("********************************************");
								
							} else if (sortingCommand.equals("0")) {
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}
					} else if (cartMenuCommand.equals("3")) {
						userCart.print();
						
						while (true) {
							removeDVDMenu();
							String removeCommand = myScanner.nextLine();
							
							if (removeCommand.equals("1")) {
								System.out.println("Please enter the id of DVd");
								int id = Integer.parseInt(myScanner.nextLine());
								DigitalVideoDisc dvd = userCart.searchById(id);
								
								if (dvd != null) {
									userCart.removeDigitalVideoDisc(dvd);
								}
							} else if (removeCommand.equals("2")) {
								System.out.println("Please enter the title of DVD");
								String title = myScanner.nextLine();
								ArrayList<DigitalVideoDisc> dvds = userCart.searchByTitle(title);
								
								if (dvds.size() != 0) {
									while (true) {
										removeOneOrAll();
										String oneOrAllCommand = myScanner.nextLine();
										
										if (oneOrAllCommand.equals("1")) {
											userCart.removeDigitalVideoDisc(dvds.get(0));
										} else if (oneOrAllCommand.equals("2")) {
											for (DigitalVideoDisc dvd: dvds) {
												userCart.removeDigitalVideoDisc(dvd);
											}
										} else if (oneOrAllCommand.equals("0")) {
											break;
										} else {
											System.out.println("Wrong command, try again !");
										}
									}
								}
							} else if (removeCommand.equals("0")) {
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}
					} else if (cartMenuCommand.equals("4")) {
						System.out.println("An order is created !!!");
						userCart = new Cart();
					} else if (cartMenuCommand.equals("0")) {
						break;
					} else {
						System.out.println("Wrong command, try again !");
					}
				}
				
			} else if (showMenuCommand.equals("0")) {
				System.out.println("End AIMS program !");
				break;
			} else {
				System.out.println("Wrong command, try again !");
			}
		}
	}
}

