package com.example.demo.service.serviceImpl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;
    @Autowired
    CuaHangService cuaHangService;
    @Autowired
    ChucVuService chucVuService;

    @Override
    public List<NhanVien> getAll() {
        return this.nhanVienRepo.findAll();
    }

    @Override
    public NhanVien getById(UUID idNhanVien) {
        return this.nhanVienRepo.findById(idNhanVien).get();
    }

    @Override
    public NhanVien getByMa(String idNhanVien) {
        return this.nhanVienRepo.getByMa(idNhanVien).get(0);
    }

    @Override
    public NhanVien create(NhanVien nhanVien) {
        nhanVien.setTrangThai(true);
        return this.nhanVienRepo.save(nhanVien);
    }

    @Override
    public NhanVien changeTrangThai(UUID idNhanVien) {
        NhanVien nhanVien = this.getById(idNhanVien);
        if (nhanVien.isTrangThai() == true) {
            nhanVien.setTrangThai(false);
        } else {
            nhanVien.setTrangThai(true);
        }
        return this.nhanVienRepo.save(nhanVien);
    }

    @Override
    public NhanVien update(UUID id, String ma, String ten, String tenDem, String ho, boolean gioiTinh,
                           Date ngaySinh, String diaChi, String sdt, String matKhau, UUID idCuaHang, UUID idChucVu, Boolean trangThai) {
        NhanVien nhanVien = this.getById(id);
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        nhanVien.setTenDem(tenDem);
        nhanVien.setHo(ho);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setDiaChi(diaChi);
        nhanVien.setSdt(sdt);
        nhanVien.setMatKhau(matKhau);
        nhanVien.setCuaHang(this.cuaHangService.getById(idCuaHang));
        nhanVien.setChucVu(this.chucVuService.getById(idChucVu));
        nhanVien.setTrangThai(trangThai);
        return this.nhanVienRepo.save(nhanVien);
    }

    @Override
    public NhanVien deleteById(UUID idNhanVien) {
        return null;
    }
}
