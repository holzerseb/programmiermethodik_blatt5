import java.util.*;

/**
 * Created by user on 07.05.2017.
 */
public class Album
{
    /* # Members # */

    private String name;
    //The reason I use List here is because we can't assure there ain't no duplicates
    //and sometimes those titles have to be ordered
    private List<String> titles;
    private int releaseYear;

    /* # Constructors # */

    //I used arraylist, because get is in constant time (and we usually want to
    //access the titles, rather than adding/removing one)
    //adding anyhwere but the end would require to shift over all items from an end before
    //but in our implementation, we usually add it to the end :)
    private Album()
    {
        this.titles = new ArrayList<>();
    }

    /**
     * Some really good JavaDoc
     * @param name
     */
    public Album(String name)
    {
        this();
        this.name = name;
    }

    /**
     * ...
     * @param name
     * @param releaseYear
     */
    public Album(String name, int releaseYear)
    {
        this();
        this.name = name;
        this.releaseYear = releaseYear;
    }

    /* # Properties # */

    /**
     * Gets the name of the Album
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
    public List<String> getTitles()
    {
        return titles;
    }

    /**
     * Yeah, guess what it does
     * @return
     */
    public int getReleaseYear()
    {
        return releaseYear;
    }

    /**
     * Because I can imagine someone wants to change
     * the release year (when he didn't know the year
     * on creating the album-object)
     * @param releaseYear
     */
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    /* # Methods # */

    /**
     * Adds a title, no jokes!
     * @param titleName
     */
    public void addTitle(String titleName)
    {
        //maybe some verifications...
        //duplicates are allowed on purpose (can we really
        //be sure the artist doesn't name two titles the same way?)
        this.titles.add(titleName);
    }

    /**
     * Removes a title by his name
     * @param titleName
     */
    public void removeTitle(String titleName) throws NoSuchElementException
    {
        if(!this.titles.contains(titleName))
            throw new NoSuchElementException("The title " + titleName + " doesn't exist in this album yet.");

        this.titles.remove(titleName);
    }

    /**
     * Removes a title by his index
     * @param titleIndex
     */
    public void removeTitle(int titleIndex) throws IndexOutOfBoundsException
    {
        if(titleIndex >= this.titles.size() || titleIndex < 0)
            throw new IndexOutOfBoundsException("There is no title with index " + titleIndex + ". Sorry m8.");

        this.titles.remove(titleIndex);
    }

    /* # Comparator # */

    public static class AlbumComparator implements Comparator<Album>
    {
        /**
         * Returns 0 if equal
         * positive value if first Album was released more years ago (aka first Greater)
         * negative value if first Album was released more recently.
         * @param first
         * @param second
         * @return
         */
        @Override
        public int compare (Album first, Album second)
        {
            if (first == null && second == null)
                return 0;
            else if (first == null)
                return -1;
            else if (second == null)
                return 1;


            //because first album is "greater", when the releaseYear is smaller
            return second.releaseYear - first.releaseYear;
        }
    }
}
