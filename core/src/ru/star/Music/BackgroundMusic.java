package ru.star.Music;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


public class BackgroundMusic implements Music{

    private Music music;

    public BackgroundMusic(){
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
    }

    @Override
    public void play() {
        music.play();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setLooping(boolean isLooping) {

    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setVolume(float volume) {
         music.setVolume(volume);
    }

    @Override
    public float getVolume() {
        return music.getVolume();
    }

    @Override
    public void setPan(float pan, float volume) {

    }

    @Override
    public void setPosition(float position) {

    }

    @Override
    public float getPosition() {
        return 0;
    }

    @Override
    public void dispose() {
        music.play();
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {

    }


}
