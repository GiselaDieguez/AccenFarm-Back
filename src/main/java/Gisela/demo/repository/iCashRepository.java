package Gisela.demo.repository;

import Gisela.demo.model.Cash;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCashRepository extends JpaRepository<Cash, Long> {
    @Query(value = "SELECT SUM(transactionamt * buyprice) as totalcash\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.dimproducts dm\n" +
            "ON ft.productid = dm.productid \n" +
            "INNER JOIN public.dimtransactiontype dt\n" +
            "ON dm.productid = dt.productid \n" +
            "WHERE dt.id IN (2, 7) ", nativeQuery = true)
    List<Cash> showCash();

}
