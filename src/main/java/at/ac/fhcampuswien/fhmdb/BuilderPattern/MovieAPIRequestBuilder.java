package at.ac.fhcampuswien.fhmdb.BuilderPattern;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieAPIRequestBuilder {
    private final StringBuilder url;
    private boolean hasParams = false;

    public MovieAPIRequestBuilder(String baseUrl) {
        this.url = new StringBuilder(baseUrl);
    }

    public MovieAPIRequestBuilder query(String query) {
        return addQueryParam("query", query);
    }

    public MovieAPIRequestBuilder genre(Genre genre) {
        if (genre != null) {
            return addQueryParam("genre", genre.toString());
        }
        return this;
    }

    public MovieAPIRequestBuilder releaseYear(String releaseYear) {
        return addQueryParam("releaseYear", releaseYear);
    }

    public MovieAPIRequestBuilder ratingFrom(String ratingFrom) {
        return addQueryParam("ratingFrom", ratingFrom);
    }

    private MovieAPIRequestBuilder addQueryParam(String key, String value) {
        if (value != null && !value.isEmpty()) {
            if (hasParams) {
                url.append("&");
            } else {
                url.append("?");
                hasParams = true;
            }
            url.append(key).append("=").append(value);
        }
        return this;
    }

    public String build() {
        return url.toString();
    }
}
