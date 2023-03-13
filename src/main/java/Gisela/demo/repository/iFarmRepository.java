package Gisela.demo.repository;
import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFarmRepository extends JpaRepository<Farm, Long> {

    @Query(value = "SELECT ft.time\n" +
            "\t, dm.productnm\n" +
            "\t, dt.transactionnm\n" +
            "\t, ft.transactionamt \n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "LEFT JOIN public.dimproducts dm\n" +
            "ON ft.productid = dm.productid \n" +
            "LEFT JOIN public.dimtransactiontype dt\n" +
            "ON dm.productid = dt.productid", nativeQuery = true)
    List<Farm> findProductNm();

}
