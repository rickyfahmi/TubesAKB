package com.example.mypersonalapps;
/*Nama : Ricky Fahmi Nugraha
NIM  : 10116150
KELAS : AKB-IF4
Tanggal Pengerjaan : 10 Agustus 2019*/
import java.util.ArrayList;
import java.util.List;

public class ImplementasiPresenter implements MainPresenter {

    private FriendView friendView;
    private List<FriendModel> friends = new ArrayList<>();
    private int no = 4;


    public ImplementasiPresenter(FriendView friendView){
        this.friendView=friendView;
        setData();
    }

    public void setData(){
        FriendModel friend =new FriendModel();
        friend.setNim(10116375);
        friend.setNama("William");
        friend.setKelas("IF-9");
        friend.setNohp("082248461730");
        friend.setEmail("manuputtywilliam@gmail.com");
        friend.setSosmed("williamm9914");
        friends.add(friend);

        FriendModel friend1 =new FriendModel();
        friend.setNim(10116154);
        friend.setNama("Ferry Hermawan");
        friend.setKelas("IF-4");
        friend.setNohp("082248468888");
        friend.setEmail("ferry@gmail.com");
        friend.setSosmed("mpew");
        friends.add(friend1);

        FriendModel friend2 =new FriendModel();
        friend.setNim(10116168);
        friend.setNama("Afif Rizky Darmawan");
        friend.setKelas("IF-4");
        friend.setNohp("082248469999");
        friend.setEmail("afifrd@gmail.com");
        friend.setSosmed("ard186");
        friends.add(friend2);
    }

    @Override
    public void save(FriendModel friend){
        no++;
        friend.setNim(no);
        friends.add(friend);
        friendView.onSave();
    }

    @Override
    public void update(FriendModel friend) {
        for (FriendModel model : friends){
            if(model.getNim()==friend.getNim()){
                model.setNama(friend.getNama());
                model.setKelas(friend.getKelas());
                model.setNohp(friend.getNohp());
                model.setEmail(friend.getEmail());
                model.setSosmed(friend.getSosmed());

                break;
            }

            friendView.onUpdate();
        }
    }

    @Override
    public void delete(FriendModel friend) {
        friends.remove(friend);
        friendView.onDelete();
    }

    @Override
    public void load() {
        friendView.onLoad(friends);
    }
}
