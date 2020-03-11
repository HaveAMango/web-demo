package lv.accenture.bootcamp.webdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {
	
	@Query("SELECT c FROM Cat c WHERE c.nickname LIKE %:nickname%")
	List <Cat> findByNickname(@Param(value="nickname")String catName);
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Component
	//private List<Cat> cats = new ArrayList<>();
//
//	public CatRepository() {
//		cats.add(new Cat(1L, "Muris", 5,
//				"https://images-na.ssl-images-amazon.com/images/I/61YDY3QPTRL._AC_SL1000_.jpg"));
//		cats.add(new Cat(2L, "Murka", 3, "https://i.redd.it/g3q78obsja121.jpg"));
//		cats.add(new Cat(3L, "Garfield", 7,
//				"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSbuwYXt4Ssv6DX_ipcxnbNpDe6WaNxrCqy557HoRmzhr6j-4CD"));
//		cats.add(new Cat(4L, "Cat", 8, "https://i.pinimg.com/originals/9e/06/91/9e06919904f4af5c6734b51a74660491.jpg"));
//
//	}
//
//	public List<Cat> findAll() {
//		return cats;
//	}
//
//	public void add(Cat cat) {
//		List<Long> id = new ArrayList<>();
//		for (Cat i : cats) {
//			id.add(i.getId());
//		}
//		Long max = Long.MIN_VALUE;
//		for (Long i : id) {
//			if (i > max) {
//				max = i;
//			}
//		}
//		max = max + 1;
//		cat.setId(max);
//		cats.add(cat);
//	}
//
//	public Cat findById(Long id) {
//		for (Cat i : cats) {
//			if (i.getId().equals(id)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Cat by id: " + id + "not found!");
//	}
//
//	public void update(Cat editedCat) {
//		for (int i = 0; i < cats.size(); i++) {
//			if (cats.get(i).getId().equals(editedCat.getId())) {
//				cats.set(i, editedCat);
//				return;
//			}
//		}
//		throw new IllegalArgumentException("Cat by id: " + editedCat.getId() + " not found");
//
//	}
//
//	public void delete(Long id) {
//		Cat catById = findById(id);
//		cats.remove(catById);
//	}
//
//	public List<Cat> findByNickname(String catName) {
//		List<Cat> foundCats = new ArrayList<>();
//
//		for(int i = 0; i< cats.size(); i++) {
//			if(cats.get(i).getNickname().equalsIgnoreCase(catName)) {
//				foundCats.add(cats.get(i));
//			}
//		}
//		return foundCats;
//	}
}
