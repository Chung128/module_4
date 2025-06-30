create database quan_li_thong_tin_benh_nhan;
use quan_li_thong_tin_benh_nhan;

create table khoa (
    ma_khoa varchar(10) primary key,
    ten_khoa varchar(100) not null,
    loai_khoa varchar(50)
);

create table phong (
    ma_phong varchar(10) primary key,
    ten_phong varchar(100) not null,
    loai_phong varchar(50),
    ma_khoa varchar(10),
    foreign key (ma_khoa) references khoa(ma_khoa)
);

create table giuong (
    ma_giuong varchar(10) primary key,
    ma_phong varchar(10),
    trang_thai varchar(50),
    foreign key (ma_phong) references phong(ma_phong)
);

create table benh_nhan (
    ma_benh_nhan varchar(10) primary key,
    ho_ten varchar(100) not null,
    ngay_sinh date,
    gioi_tinh varchar(10),
    dia_chi varchar(200),
    so_dien_thoai varchar(15),
    bao_hiem_y_te bit default 0, 
    email varchar(100)
);

create table nhan_vien (
    ma_nhan_vien varchar(10) primary key,
    ho_ten varchar(100) not null,
    vai_tro varchar(50) not null,
    ma_khoa varchar(10),
    email varchar(100),
    mat_khau varchar(100) not null,
    foreign key (ma_khoa) references khoa(ma_khoa)
);


create table lich_phan_cong (
    ma_phan_cong varchar(10) primary key,
    ma_bac_si varchar(10),
    ma_phong varchar(10),
    ngay_phan_cong date,
    gio_bat_dau time,
    gio_ket_thuc time,
    foreign key (ma_bac_si) references nhan_vien(ma_nhan_vien),
    foreign key (ma_phong) references phong(ma_phong)
);


create table lich_kham (
    ma_lich_kham varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_phong varchar(10),
    ma_bac_si varchar(10),
    ngay_kham date not null,
    gio_kham time,
    so_thu_tu int,
    trang_thai varchar(50) default 'Đang chờ',
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_phong) references phong(ma_phong),
    foreign key (ma_bac_si) references nhan_vien(ma_nhan_vien)
);

create table ket_qua_xet_nghiem (
    ma_xet_nghiem varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_phong varchar(10),
    ma_ky_thuat_vien varchar(10),
    ten_xet_nghiem varchar(100),
    ket_qua varchar(500),
    ngay_thuc_hien date,
    trang_thai varchar(50),
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_phong) references phong(ma_phong),
    foreign key (ma_ky_thuat_vien) references nhan_vien(ma_nhan_vien)
);

create table don_thuoc (
    ma_don_thuoc varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_bac_si varchar(10),
    ngay_ke_don date,
    chi_tiet_don_thuoc varchar(500),
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_bac_si) references nhan_vien(ma_nhan_vien)
);

create table ho_so_nhap_vien (
    ma_ho_so varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_phong varchar(10),
    ma_giuong varchar(10),
    ma_bac_si varchar(10),
    ngay_nhap_vien date,
    ngay_xuat_vien date,
    ket_luan varchar(500),
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_phong) references phong(ma_phong),
    foreign key (ma_bac_si) references nhan_vien(ma_nhan_vien)
);

create table thanh_toan (
    ma_thanh_toan varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_nhan_vien varchar(10),
    loai_chi_phi varchar(50),
    so_tien decimal(10,2),
    ngay_thanh_toan date,
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien)
);

create table thong_bao_tai_kham (
    ma_thong_bao varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ngay_tai_kham date,
    noi_dung varchar(200),
    ngay_gui date,
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan)
);

create table do_huyet_ap_can_nang (
    ma_do varchar(10) primary key,
    ma_benh_nhan varchar(10),
    ma_y_ta varchar(10),
    huyet_ap varchar(20),
    can_nang decimal(5,2),
    ngay_do date,
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
    foreign key (ma_y_ta) references nhan_vien(ma_nhan_vien)
);

create table quyen_truy_cap (
    ma_quyen varchar(10) primary key,
    vai_tro varchar(50),
    chuc_nang varchar(100),
    mo_ta varchar(200)
);