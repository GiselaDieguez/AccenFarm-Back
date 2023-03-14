package Gisela.demo.repository;
import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFarmRepository extends JpaRepository<Farm, Long> {

    @Query(value = "SELECT ft.time\n" +
            "       , pb.productnm\n" +
            "\t     , pb.productprice\n" +
            "       , ft.transactionamt\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.buyproducts pb\n" +
            "ON ft.productid = pb.productid ", nativeQuery = true)
    List<Farm> buyProducts();

    @Query(value = "SELECT ft.time\n" +
            "       , ps.productnm\n" +
            "\t     , ps.productprice\n" +
            "       , ft.transactionamt\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.sellproducts ps\n" +
            "ON ft.productid = ps.productid  ", nativeQuery = true)
    List<Farm> sellProducts();

    @Query(value = "SELECT ft.time\n" +
            "       , ps.productnm\n" +
            "\t     , ps.productprice\n" +
            "       , ft.transactionamt\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.sellproducts ps\n" +
            "ON ft.productid = ps.productid  ", nativeQuery = true)
    List<Farm> dropProducts();

}
