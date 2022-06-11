package hust.soict.dsai.aims;

import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.utils.MediaUtils;

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
		System.out.println("1. See a medium's details");
		System.out.println("2. Add a medium to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a disc");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove a medium from cart");
		System.out.println("4. Place order");
		System.out.println("5. Play a disc");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	private static void updateStoreMenu() {
		System.out.println("Do you want to add or remove a medium ?");
		System.out.println("------------------------------");
		System.out.println("1. Add a medium to store");
		System.out.println("2. Remove a medium from store");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void yesNoMenu() {
		System.out.println("Do you want to add this medium to cart ?");
		System.out.println("------------------------------");
		System.out.println("1. Yes");
		System.out.println("0. No");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	private static void removeMediaMenu() {
		System.out.println("Do you want remove a medium by id or title ?");
		System.out.println("------------------------------");
		System.out.println("1. Remove by id");
		System.out.println("2. Remove by title");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-2");
	}
	
	private static void removeOneOrAll() {
		System.out.println("Do you want remove one or all matching media ?");
		System.out.println("------------------------------");
		System.out.println("1. Remove one matching medium");
		System.out.println("2. Remove all matching media");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-2");
	}
	
	private static void filterMediaMenu() {
		System.out.println("Do you want to filter media by id or by title ?");
		System.out.println("------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void sortMediaMenu() {
		System.out.println("Do you want to sort the cart by id or by title ?");
		System.out.println("------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void addDiscOrBook() {
		System.out.println("Do you want to add a media or a book ?");
		System.out.println("------------------------------");
		System.out.println("1. Add a book");
		System.out.println("2. Add a disc");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 1-2");
	}
	
	private static void playADiscInCart(Scanner myScanner, Cart userCart) {
		System.out.println("Please enter the title of the disc you want to play: ");
		outer:
		while (true) {
			if (userCart.getItemsOrdered().size() == 0) {
				System.out.println("Empty cart");
				break;
			}
			String title = myScanner.nextLine();
			List<Media> media = userCart.searchByTitle(title);
			
			if (media.size() == 0) {
				System.out.println("Please enter a valid disc name");
			} else {
				for (Media medium: media) {
					if (medium instanceof Playable) {
						DigitalVideoDisc newMedium = (DigitalVideoDisc) medium;
						newMedium.play();
						break outer;
					}
				}
				System.out.println("No mathcing compact disc or digital disc with title " + title + " in cart, try again");
			}
		}
		
	}

	public static void main(String[] args) {
		MemoryDaemon memoryDaemon = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemon);
		thread.setDaemon(true);
		thread.start();
		
		//Create a new cart
		Cart userCart = new Cart();
		
		//Create new dvd objects and add them to the cart
		Media dvd1 = new DigitalVideoDisc("The Lion King",
				"Amimation", "Roger Allers", 87, 19.95f);
		//cart.addDigitalVideoDisc(dvd1);
		
		Media dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		//cart.addDigitalVideoDisc(dvd2);
		
		Media cd1 = new CompactDisc("Aladin", 
				"Amimation", 18.99f);
		//cart.addDigitalVideoDisc(dvd3);
		
		Media dvd4 = new DigitalVideoDisc("End Game");
		
		Book book1 = new Book("Harry Poster", "Wizard", 10f);
		book1.addAuthor("Conan Doyle");
		book1.addAuthor("JK Rolling");
		
		//Create a store
		Store store = new Store();
		store.addMedia(dvd1, dvd2, cd1, dvd4, book1);
		Scanner myScanner = new Scanner(System.in);
		
		while (true) {
			showMenu();
			String showMenuCommand = myScanner.nextLine();
			
			if (showMenuCommand.equals("1")) {
				
				while (true) {
					storeMenu();
					String storeMenuCommand = myScanner.nextLine();
					
					if (storeMenuCommand.equals("1")) {
						System.out.println("Please enter the title of the medium");
						String title = myScanner.nextLine();
						
						//check the validity of title
						List<Media> media = store.searchByTitle(title);
						if (media.size() != 0) {
							for (Media medium: media) {
								System.out.println("The infomation of medium with title " + title + " :");
								System.out.print(medium);
								
								while (true) {
									yesNoMenu();
									String yesNoCommand = myScanner.nextLine();
									
									if (yesNoCommand.equals("1")) {
										userCart.addMedia(medium);
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
						System.out.println("The infomation about media in store:");
						store.displayMedia();
						System.out.println("------------------------------");
						System.out.println("Please enter the title of the medium");
						String title = myScanner.nextLine();
						List<Media> media = store.searchByTitle(title);
						
						if (media.size() != 0) {
							for (Media medium: media) {
								userCart.addMedia(medium);
								System.out.println("The infomation about medium with title " + title + " :");
								System.out.println(medium);
							}
						}
					} else if (storeMenuCommand.equals("3")) {
						userCart.print();
						
						while (true) {
							System.out.println("Do you want to play a disc in cart ?");
							System.out.println("------------------------------");
							System.out.println("1. Yes");
							System.out.println("0. No");
							System.out.println("------------------------------");
							System.out.println("Please choose a number: 0-1");
							String yesNo = myScanner.nextLine();
							
							if (yesNo.equals("1")) {
								playADiscInCart(myScanner, userCart);
								break;
							} else if (yesNo.equals("0")) {
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}
					} else if (storeMenuCommand.equals("4")) {
						System.out.println("Please enter the title of the disc you want to play: ");
						outer:
						while (true) {
							if (store.getItemsInStore().size() == 0) {
								System.out.println("Empty store");
								break;
							}
							String title = myScanner.nextLine();
							List<Media> media = store.searchByTitle(title);
							
							if (media.size() == 0) {
								System.out.println("Please enter a valid disc name");
							} else {
								for (Media medium: media) {
									if (medium instanceof Playable) {
										DigitalVideoDisc newMedium = (DigitalVideoDisc) medium;
										newMedium.play();
										break outer;
									}
								}
								System.out.println("No mathcing compact disc or digital disc with title " + title + " in store, try again");
							}
						}

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
						
						while (true) {
							addDiscOrBook();
							String addBookOrDisc = myScanner.nextLine();
							
							if (addBookOrDisc.equals("1")) {
								System.out.println("Please enter the infomation of book");
								
								System.out.println("Please enter the title of book, press 0 to pass over");
								String title = myScanner.nextLine();
								
								System.out.println("Please enter the category of book, press 0 to pass over");
								String category = myScanner.nextLine();
								
								System.out.println("Please enter the cost of book, press 0 to pass over");
								float cost = Float.parseFloat(myScanner.nextLine());
								
								store.addMedia(new Book(title, category, cost));
								break;
							} else if (addBookOrDisc.equals("2")) {
								System.out.println("Please enter the infomation of disc");
								
								System.out.println("Please enter the title of disc, press 0 to pass over");
								String title = myScanner.nextLine();
								
								System.out.println("Please enter the category of disc, press 0 to pass over");
								String category = myScanner.nextLine();
								
								System.out.println("Please enter the director of dics, press 0 to pass over");
								String director = myScanner.nextLine();
								
								System.out.println("Please enter the length of dics, press 0 to pass over");
								int length = Integer.parseInt(myScanner.nextLine());
								
								System.out.println("Please enter the cost of disc, press 0 to pass over");
								float cost = Float.parseFloat(myScanner.nextLine());
								
								store.addMedia(new Disc(title, category, director, length, cost));
								break;
							} else {
								System.out.println("Wrong command, try again !");
							}
						}
					} else if (addRemoveCommand.equals("2")) {
						System.out.println("------------------------------");
						System.out.println("The infomation about DVDs in store:");
						store.displayMedia();
						System.out.println("------------------------------");
						
						while (true) {
							//When a DVD is removed from store, it will be also removed from userCart
							System.out.println("------------------------------");
							System.out.println("The infomation about media in store:");
							store.displayMedia();
							System.out.println("------------------------------");
							removeMediaMenu();
							String removeCommand = myScanner.nextLine();
							
							if (removeCommand.equals("1")) {
								System.out.println("Please enter the id of medium");
								int id = myScanner.nextInt();
								myScanner.nextLine();
								Media medium = store.searchById(id);
								
								if (medium != null) {
									store.removeMedia(medium);
									userCart.removeMedia(medium);
								}
							} else if (removeCommand.equals("2")) {
								System.out.println("Please enter the title of medium");
								String title = myScanner.nextLine();
								List<Media> media = store.searchByTitle(title);
								
								if (media.size() != 0) {
									while (true) {
										removeOneOrAll();
										String oneOrAllCommand = myScanner.nextLine();
										
										if (oneOrAllCommand.equals("1")) {
											store.removeMedia(media.get(0));
											userCart.removeMedia(media.get(0));
											break;
										} else if (oneOrAllCommand.equals("2")) {
											for (Media medium: media) {
												store.removeMedia(medium);
												userCart.removeMedia(medium);
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
							filterMediaMenu();
							String filteringCommand = myScanner.nextLine();
							
							if (filteringCommand.equals("1")) {
								System.out.println("Please enter the id of medium");
								int id = myScanner.nextInt();
								myScanner.nextLine();
								Media medium = userCart.searchById(id);
								
								if (medium != null) {
									System.out.println(medium);
								}
							} else if (filteringCommand.equals("2")) {
								System.out.println("Please enter the title of medium");
								String title = myScanner.nextLine();
								List<Media> media = userCart.searchByTitle(title);
								
								if (media.size() != 0) {
									for (Media medium: media) {
										System.out.println(medium);
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
							sortMediaMenu();
							String sortingCommand = myScanner.nextLine();

							if (sortingCommand.equals("1")) {
								List<Media> sortedCart = userCart.getItemsOrdered();
								sortedCart = MediaUtils.sortByCost(sortedCart);
								sortedCart = MediaUtils.sortByTitle(sortedCart);
								
								System.out.println("********************CART********************");
								System.out.println("Ordered Items:");
								System.out.println(sortedCart.size());
								
								for (int j = 0; j < sortedCart.size(); j++) {
									System.out.println(j + 1 + ". DVD - " + sortedCart.get(j));
								}
								
								//System.out.println("Total cost: " + this.totalCost() + " $");
								System.out.println("********************************************");
	
							} else if (sortingCommand.equals("2")) {
								List<Media> sortedCart = userCart.getItemsOrdered();
								sortedCart = MediaUtils.sortByTitle(sortedCart);
								sortedCart = MediaUtils.sortByCost(sortedCart);
								
								System.out.println("********************CART********************");
								System.out.println("Ordered Items:");
								
								for (int j = 0; j < sortedCart.size(); j++) {
									System.out.println(j + 1 + ". DVD - " + sortedCart.get(j));
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
							removeMediaMenu();
							String removeCommand = myScanner.nextLine();
							
							if (removeCommand.equals("1")) {
								System.out.println("Please enter the id of medium");
								int id = Integer.parseInt(myScanner.nextLine());
								Media medium = userCart.searchById(id);
								
								if (medium != null) {
									userCart.removeMedia(medium);
								}
							} else if (removeCommand.equals("2")) {
								System.out.println("Please enter the title of medium");
								String title = myScanner.nextLine();
								List<Media> media = userCart.searchByTitle(title);
								
								if (media.size() != 0) {
									while (true) {
										removeOneOrAll();
										String oneOrAllCommand = myScanner.nextLine();
										
										if (oneOrAllCommand.equals("1")) {
											userCart.removeMedia(media.get(0));
										} else if (oneOrAllCommand.equals("2")) {
											for (Media medium: media) {
												userCart.removeMedia(medium);
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
						if (userCart.getItemsOrdered().size() == 0) {
							System.out.println("You cannot place an empty order!\n");
						} else {
							Media luckyItem = userCart.getALuckyItem();
							
							if (luckyItem != null) {
								System.out.println(luckyItem);
								userCart.print(luckyItem);
							} else {
								userCart.print();
							}
							
							System.out.println("An order is created !!!");
							userCart = new Cart();
						}
					} else if (cartMenuCommand.equals("5")) {
						while (true) {
							if (userCart.getItemsOrdered().size() == 0) {
								System.out.println("Empty cart");
								break;
							}
							playADiscInCart(myScanner, userCart);
							break;
						}
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

