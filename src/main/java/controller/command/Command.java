/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

/**
 *
 * @author Charlie
 */
public interface Command<T> {
    public T execute();
}
