with most_view_user as (
    select MovieRating.user_id, name, count(rating) as rating_count
    from MovieRating
        inner join Users on MovieRating.user_id = Users.user_id
    group by MovieRating.user_id
    order by rating_count desc, name
    limit 1
), highest_average_movie as (
    select MovieRating.movie_id, title, avg(rating) as rating_average
    from MovieRating
        inner join Movies on MovieRating.movie_id = Movies.movie_id
    where created_at like '2020-02%'
    group by MovieRating.movie_id
    order by rating_average desc, title
    limit 1
)

select title as results
from highest_average_movie
union all
select name as results
from most_view_user;
