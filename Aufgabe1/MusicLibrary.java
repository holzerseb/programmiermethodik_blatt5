import java.util.*;

/**
 * Created by user on 07.05.2017.
 */
public class MusicLibrary
{
        /* # Members # */

    //The reason I use List here is because the artists have to be sorted
    private List<Artist> artistList;
    //
    //the hashmap I've used is for storing the title as key and "connect" it to
    //a list of all artists performing this song
    //A title shouldn't be allowed to be stored as a duplicate, so we use a hashmap
    //Yet, a artist can perform a cover of his own song, so we could want the value to
    //be a duplicate
    //
    //the list of artists on the other hand is a set, because the artists don't have
    //to be sorted, we just want to keep track of 'em
    //The set is a hashset actually because inserting, searching and deleting is always equal fast everywhere
    private HashMap<String, Set<Artist>> songRelatedArtists;

    /* # Constructors # */

    /**
     * Some really good JavaDoc
     */
    public MusicLibrary()
    {
        this.artistList = new ArrayList<>();
        this.songRelatedArtists = new HashMap<>();
    }

    /**
     * Another good JavaDoc
     * @param artistList
     */
    public MusicLibrary(List<Artist> artistList)
    {
        this.artistList = artistList;
        this.songRelatedArtists = new HashMap<>();

        refreshArtistMap();
    }

    /* # Properties # */

    /**
     * getteeer
     * @return
     */
    public Set<Artist> getArtists()
    {
        return new HashSet<>(this.artistList);
    }

    /* # Public Methods # */

    /**
     * Adds an album
     * @param artist
     */
    public void addArtist(Artist artist)
    {
        if(this.artistList.contains(artist))
            return;

        this.artistList.add(artist);
        Collections.sort(this.artistList, new Artist.ArtistComparator());

        //Also add this artist to our map
        addArtistToMap(artist);
    }

    /**
     * Removes an album
     * @param artist
     */
    public void removeArtist(Artist artist)
    {
        this.artistList.remove(artist);
        //there really is no need to sort again - when we remove an object from an sorted list
        //the list still stays sorted :)

        //when we remove a artist from the library, we also have to delete
        //each reference to songs in our Hashmap (Index..)
        for(Set<Artist> artists : this.songRelatedArtists.values())
        {
            if(artists.contains(artist))
                artists.remove(artist);
        }
    }

    /**
     * Searches for the given title and returns a list
     * of all Artists performing this title
     * @param title
     * @return Set of artists, or null if there is no entry for the given title
     */
    public Set<Artist> searchTitle(String title)
    {
        return songRelatedArtists.get(title);
    }

    /**
     * Find a title
     * @param index
     * @return
     */
    @Deprecated
    public Set<Artist> findTitle(int index)
    {
        //I really didn't understand the task on returning the list by index
        //because if i use a hashmap where the title is the key, what exactly would a index
        //be for?

        //It wouldn't even make sense to me for using an integer-index at all - why would
        //someone want to use for example "214" over "mySong" to find his favourite song?
        return null;
    }

    /* # Private Methods # */

    /**
     * Refreshes the Index with all Titles and their artists
     */
    private void refreshArtistMap()
    {
        for(Artist artist : artistList)
        {
            addArtistToMap(artist);
        }
    }

    /**
     * Adds just a single artist to the Index-Map
     */
    private void addArtistToMap(Artist artist)
    {
        ListIterator<Album> albumIterator = artist.getAlbums().listIterator();
        while(albumIterator.hasNext())
        {
            for(String title : albumIterator.next().getTitles())
            {
                //we check if this title is already in our list
                if(this.songRelatedArtists.containsKey(title))
                {
                    //and if so, we check if this artist is "mapped" to this title
                    Set<Artist> artistsPerformingThisSong = this.songRelatedArtists.get(title);
                    if(artistsPerformingThisSong.contains(artist))
                        continue; //whereas a artist could perform a cover of his own song - do
                    //we want to have duplicates then?

                    //if not, we gonna add him
                    artistsPerformingThisSong.add(artist);
                }
                else
                {
                    //if the title ain't in our list, we must create it
                    this.songRelatedArtists.put(title, new HashSet<Artist>());
                    this.songRelatedArtists.get(title).add(artist);
                }
            }
        }
    }
}
