
# BasicCRUDApplication

REST API application with in-memory database(H2).




## Methods

- Create disk
- Get disk by id
- Get all disks
- Delete disk by id
- Delete all disks
- Modify disk by id




## Disk Variables



`name`, `description`, `genre`, `rating`, `directors`, `cover`




## Request Example
So to test this out add something to the database, generate post request(e.g. postman): http://localhost:8080/api/disks

{

    "name": "La-La-Land",

    "description": "Sebastian (Ryan Gosling) and Mia (Emma Stone) are drawn together by their common desire to do what they love. But as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",

    "genre": "Musical, Romance, Comedy, Drama",

    "rating": "10",

    "directors": "Damien Chazelle",

    "cover": "https://www.imdb.com/title/tt3783958/mediaviewer/rm2974620929/?ref_=tt_ov_i"
}



