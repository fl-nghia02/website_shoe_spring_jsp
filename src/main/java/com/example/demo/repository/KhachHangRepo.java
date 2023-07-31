package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, UUID> {
    @Query(name = "SELECT o FROM KhachHang o WHERE o.ma = ?1")
    List<KhachHang> getByMa(String ma);
}
