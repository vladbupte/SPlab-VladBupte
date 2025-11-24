
package ro.uvt.dp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.dp.models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
