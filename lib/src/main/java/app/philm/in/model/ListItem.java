package app.philm.in.model;

import app.philm.in.controllers.MovieController;

public class ListItem<T> {

    public static final int TYPE_ITEM = 0;
    public static final int TYPE_SECTION = 1;

    private final int type;

    private T item;
    private MovieController.MovieQueryType header;
    private MovieController.Filter filter;

    public ListItem(T item) {
        type = TYPE_ITEM;
        this.item = item;
    }

    public ListItem(MovieController.Filter filter) {
        type = TYPE_SECTION;
        this.filter = filter;
    }

    public ListItem(MovieController.MovieQueryType queryType) {
        type = TYPE_SECTION;
        header = queryType;
    }

    public int getType() {
        return type;
    }

    public T getItem() {
        return item;
    }

    public MovieController.Filter getFilter() {
        return filter;
    }

    public MovieController.MovieQueryType getHeader() {
        return header;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListItem listItem = (ListItem) o;

        if (type != listItem.type) {
            return false;
        }
        if (filter != null ? !filter.equals(listItem.filter) : listItem.filter != null) {
            return false;
        }
        if (item != null ? !item.equals(listItem.item) : listItem.item != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (filter != null ? filter.hashCode() : 0);
        return result;
    }
}
