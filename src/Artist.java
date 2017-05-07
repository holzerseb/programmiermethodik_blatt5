import java.util.*;

/**
 * Created by user on 07.05.2017.
 */
public class Artist
{
    /* # Members # */

    private String name;
    //The reason I use List here is because the albums have to be sorted
    private List<Album> albums;

    /* # Constructors # */

    /**
     * Some really good JavaDoc
     * @param name
     */
    public Artist(String name)
    {
        //Here I use a linkedlist, so i use some different types :^}
        //Also, linkedlist has a better better (constant) performance for inserting and removing
        //but takes more time to access the elements, when they're not at one of the ends of the list
        this.albums = new LinkedList<>();
        this.name = name;
    }

    /**
     * Some really good JavaDoc for another constructor
     * @param name
     * @param albums
     */
    public Artist(String name, List<Album> albums)
    {
        this.name = name;
        this.albums = albums;
    }

    /* # Properties # */

    /**
     * Gets the name of the Artist
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * :^}
     * @return
     */
    public List<Album> getAlbums()
    {
        return albums;
    }

    /* # Methods # */

    /**
     * Adds an album
     * @param album
     */
    public void addAlbum(Album album)
    {
        this.albums.add(album);
        Collections.sort(this.albums, new Album.AlbumComparator());
    }

    /**
     * Removes an album
     * @param album
     */
    public void removeAlbum(Album album)
    {
        this.albums.remove(album);
        //there really is no need to sort again - when we remove an object from an sorted list
        //the list still stays sorted :)
    }

    /* # Comparator # */

    public static class ArtistComparator implements Comparator<Artist>
    {
        /**
         * JavaDoc
         * @param first
         * @param second
         * @return
         */
        @Override
        public int compare (Artist first, Artist second)
        {
            return first.getName().compareTo(second.getName());
        }
    }
}
