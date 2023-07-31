package com.example.demo.service.serviceImpl;

import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HoaDonRepo;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;
    @Override
    public List<HoaDon> getAll() {
        return this.hoaDonRepo.findAll();
    }

    @Override
    public List<HoaDon> getAllWithTrangThai(Integer tt) {
        return null;
    }

    @Override
    public HoaDon getHoaDon(UUID idHoa) {
        return this.hoaDonRepo.findById(idHoa).get();
    }

    @Override
    public HoaDon create(HoaDon hoaDon) {
        return this.hoaDonRepo.save(hoaDon);
    }
//
//    @Override
//    public HoaDon update(UUID id, String tenNguoiNhan, String diaChi, String sdt) {
//        HoaDon hoaDon = this.getHoaDon(id);
//        hoaDon.setTenNguoiNhan(tenNguoiNhan);
//        hoaDon.setTen
//        return ;
//    }

    @Override
    public HoaDon updateTrangThai(UUID id, Integer trangThai) {
        HoaDon hoaDon = this.getHoaDon(id);
        hoaDon.setTinhTrang(trangThai);
        return this.hoaDonRepo.save(hoaDon);
    }
}
