import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		MusicLibrary myMusic = new MusicLibrary();

		// create some artists
		Artist a = new Artist("ACDC");
		Artist b = new Artist("Beatles");
		Artist c = new Artist("Clapton");
		Artist d = new Artist("Oasis");

		// create some albums
		Album a1 = new Album("Black Ice", 2008);
		Album a2 = new Album("Powerage", 1978);
		Album a3 = new Album("Backtracks", 2009);
		Album a4 = new Album("Bonfire", 1997);
		Album b1 = new Album("Yellow Submarine", 1969);
		Album b2 = new Album("I Am the Walrus", 1967);
		Album b3 = new Album("Let it Be", 1970);
		Album b4 = new Album("The White Album", 1996);
		Album c1 = new Album("Clapton", 2010);
		Album c2 = new Album("August", 1986);
		Album c3 = new Album("Back Home", 2005);
		Album c4 = new Album("Backless", 1978);
		Album d1 = new Album("Cigarettes & Alcohol", 1994);
		Album d2 = new Album("Who Feels Love?", 2000);

		// add titles to albums
		a1.addTitle("Rock ’n’ Roll Train");
		a1.addTitle("Skies on Fire");
		a1.addTitle("Big Jack");
		a1.addTitle("Anything Goes");
		a1.addTitle("War Machine");
		a1.addTitle("Smash ’n’ Grab");
		a1.addTitle("Spoilin’ for a Fight");
		a1.addTitle("Wheels");
		a1.addTitle("Decibel");
		a1.addTitle("Stormy May Day");
		a1.addTitle("She Likes Rock ’n’ Roll");
		a1.addTitle("Money Made");
		a1.addTitle("Rock ’n’ Roll Dream");
		a1.addTitle("Rocking All the Way");
		a1.addTitle("Black Ice");
		a2.addTitle("Rock 'n' Roll Damnation");
		a2.addTitle("Down Payment Blues");
		a2.addTitle("Gimme a Bullet");
		a2.addTitle("Riff Raff");
		a2.addTitle("Sin City");
		a2.addTitle("What's Next to the Moon");
		a2.addTitle("Gone Shootin’");
		a2.addTitle("Up to My Neck in You");
		a2.addTitle("Kicked in the Teeth");
		b1.addTitle("Yellow Submarine");
		b1.addTitle("Only a Northern Song");
		b1.addTitle("All Together Now");
		b1.addTitle("Hey Bulldog");
		b1.addTitle("It’s All Too Much");
		b1.addTitle("All You Need Is Love");
		b2.addTitle("I Am the Walrus");
		b4.addTitle("Helter Skelter");
		c3.addTitle("So Tired");
		c3.addTitle("Say What You Will");
		c3.addTitle("I’m Going Left");
		c3.addTitle("Love Don’t Love Nobody");
		c3.addTitle("Revolution");
		c3.addTitle("Love Comes To Everyone");
		c3.addTitle("Lost And Found");
		c3.addTitle("Piece Of My Heart");
		c3.addTitle("One Day");
		c3.addTitle("One Track Mind");
		c3.addTitle("Run Home To Me");
		c3.addTitle("Back Home");
		d1.addTitle("I Am the Walrus");
		d2.addTitle("Helter Skelter");

		// add albums to artists
		a.addAlbum(a1);
		a.addAlbum(a2);
		a.addAlbum(a3);
		a.addAlbum(a4);
		b.addAlbum(b1);
		b.addAlbum(b2);
		b.addAlbum(b3);
		b.addAlbum(b4);
		c.addAlbum(c1);
		c.addAlbum(c2);
		c.addAlbum(c3);
		c.addAlbum(c4);
		d.addAlbum(d1);
		d.addAlbum(d2);

		// finally, add artists to library
		myMusic.addArtist(a);
		myMusic.addArtist(b);
		myMusic.addArtist(c);
		myMusic.addArtist(d);

		// assign genre to artists in music library
		Set<Artist> myArtists = myMusic.getArtists();
		Map<Artist, String> artistGenre = new HashMap<>();
		Artist[] artistArray = myArtists.toArray(new Artist[myArtists.size()]);
		String[] genres = new String[] { "Rock", "Oldies", "Pop", "Pop" };
		for (int i = 0; i < artistArray.length; i++) {
			artistGenre.put(artistArray[i], genres[i]);
			System.out.println(artistArray[i]);
		}
		System.out.println(artistGenre.toString());

		// check for sorting of albums
		for (Artist artist : myArtists) {
			System.out.println("Artist: " + artist.getName() + " Albums: " + artist.getAlbums().toString());
		}



		/* NEW IMPLEMENTATIONS; DONE BY ME */

		/*
		Before doing the actual implementation, I have to tell - as stated somewhere in my sourcecode
		for the "searchTitle" method - I have really fully thought about what the Task wants me to do
		with this index. But I couldn't think of a single useful implementation for using a index.

		First, logically thought about the usage of our implementation: why would
		someone want to use for example the index "214" over "Yellow Submarine" to find his favourite song?

		Second, I could see the technical advantages over a string, but when we would read the songs
		for example from the filesystem, we really have no clue in which order we will get them? How
		can we guarantee the indizes being correct after restarting the program?

		I'm sorry I didn't implement a search-Method using the index, but considering the aspects above
		and some minor aspects furthermore (like, why make the interface to our musiclibrary more complex)
		I think it's okay to not have the second search-method. At least, I did make spend some time
		making myself some thoughts about it.
		*/

		//Searching for the titles
		for(String title : Arrays.asList("I Am the Walrus", "Helter Skelter"))
		{
			System.out.println("[INFO] Searching for \"" + title + "\"");
			Set<Artist> titleArtists = myMusic.searchTitle(title);
			System.out.println("[RESULT] Artists for Title \"" + title + "\":");
			int i = 0;
			for(Artist artist : titleArtists)
			{
				i++;
				System.out.println("\tArtist #" + i + ": \"" + artist.getName() + "\"");
			}
		}
	}
}
