import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Genre> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){ // 장르이름에 해당하는 값이 있다면
                Genre genre = map.get(genres[i]); // 장르를 가져옴
                Album album = new Album(i,plays[i]); // 앨범을 생성
                genre.addTotalPlayCount(album.playCount);
                genre.albumList.add(album); // 앨범 리스트에 앨범 추가
            }
            else{
                Genre genre = new Genre(); // 새로운 장르 생성
                Album album = new Album(i, plays[i]);
                genre.addTotalPlayCount(album.playCount);
                genre.albumList.add(album); // 새로운 앨범 생성후 앨범리스트에 장르 추가
                map.put(genres[i], genre); // 맵에 추가
            }
        }
        ArrayList<Genre> genreList = new ArrayList<>(map.values());
        Collections.sort(genreList);
        for (Genre genre: genreList){
            List<Album> albumList = genre.albumList;
            Collections.sort(albumList);
            for(int i=0; i<albumList.size(); i++){
                if(i == 2) break;
                answer.add(albumList.get(i).id);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    private static class Album implements Comparable<Album>{

        public int id;
        public int playCount;

        public Album(int id,int playCount){
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Album album) {
            int diff = album.playCount - this.playCount;
            return (diff == 0)? this.id-album.id: diff;
        }
    }
    private static class Genre implements Comparable<Genre>{
        public List<Album> albumList = new ArrayList<>();
        public int totalPlayCount = 0;

        @Override
        public int compareTo(Genre genre) {
            return genre.totalPlayCount - this.totalPlayCount;
        }
        public void addTotalPlayCount(int playCount){
            this.totalPlayCount += playCount;
        }
    }
}
