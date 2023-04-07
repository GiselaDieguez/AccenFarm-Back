package Gisela.demo.repository;
import Gisela.demo.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFarmRepository extends JpaRepository<Farm, Integer> {

    @Query(value = "SELECT ft.time\n" +
            "\t, pb.productnm\n" +
            "\t, pb.productprice\n" +
            "\t, ft.transactionamt\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.buyproducts pb\n" +
            "ON ft.productid = pb.productid \n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> buyProducts();

    @Query(value = "SELECT ft.time\n" +
            "\t, ps.productnm\n" +
            "\t, ps.productprice\n" +
            "\t, ft.transactionamt\n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.sellproducts ps\n" +
            "ON ft.productid = ps.productid \n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> sellProducts();

    @Query(value = "SELECT ft.time\n" +
            "\t, ps.productnm\n" +
            "\t, ft.transactionamt\n" +
            "\t, sp.productprice \n" +
            "FROM public.facttransactions ft (nolock)\n" +
            "INNER JOIN public.deleteproducts ps\n" +
            "ON ft.productid = ps.productid\n" +
            "INNER JOIN public.sellproducts sp\n" +
            "ON ps.operationid = sp.operationid\n" +
            "order by 1 desc", nativeQuery = true)
    List<Object[]> dropProducts();

}
