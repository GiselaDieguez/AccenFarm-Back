package Gisela.demo.repository;
import Gisela.demo.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFarmRepository extends JpaRepository<Transactions, Integer> {

    @Query(value = "SELECT ft.time\n" +
            "\t, pb.productnm\n" +
            "\t, pb.productprice\n" +
            "FROM public.facttransactions ft \n" +
            "INNER JOIN public.dimtrasactiontype pb\n" +
            "ON ft.productid = pb.productid \n" +
            "WHERE pb.productid IN (1, 2)\n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> buyProducts();

    @Query(value = "SELECT ft.time\n" +
            "\t, pb.productnm\n" +
            "\t, pb.productprice\n" +
            "FROM public.facttransactions ft \n" +
            "INNER JOIN public.dimtrasactiontype pb\n" +
            "ON ft.productid = pb.productid \n" +
            "WHERE pb.productid IN (3, 4)\n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> sellProducts();

    @Query(value = "SELECT ft.time\n" +
            "\t, pb.productnm\n" +
            "\t, pb.productprice\n" +
            "FROM public.facttransactions ft \n" +
            "INNER JOIN public.dimtrasactiontype pb\n" +
            "ON ft.productid = pb.productid \n" +
            "WHERE pb.productid IN (5, 6)\n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> dropProducts();

}
