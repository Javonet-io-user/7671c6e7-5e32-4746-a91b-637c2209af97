package Renci.SshNet;

import Common.Activation;
import static Common.Helper.Convert;
import static Common.Helper.getGetObjectName;
import static Common.Helper.getReturnObjectName;
import static Common.Helper.ConvertToConcreteInterfaceImplementation;
import Common.Helper;
import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.NObject;
import com.javonet.api.NEnum;
import com.javonet.api.keywords.NRef;
import com.javonet.api.keywords.NOut;
import com.javonet.api.NControlContainer;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Iterator;
import java.lang.*;
import Renci.SshNet.*;
import jio.System.*;
import Renci.SshNet.Common.*;

public class KeyboardInteractiveAuthenticationMethod extends AuthenticationMethod
    implements IDisposable {
  protected NObject javonetHandle;
  /** GetProperty */
  public java.lang.String getNameAsKeyboardInteractiveAuthenticationMethod() {
    try {
      java.lang.String res =
          javonetHandle.explicitInterface("Renci.SshNet.IAuthenticationMethod").invoke("get_Name");
      if (res == null) return "";
      return (java.lang.String) res;
    } catch (JavonetException _javonetException) {
      _javonetException.printStackTrace();
      return "";
    }
  }

  public KeyboardInteractiveAuthenticationMethod(java.lang.String username) {
    super((NObject) null);
    try {
      javonetHandle = Javonet.New("Renci.SshNet.KeyboardInteractiveAuthenticationMethod", username);
      super.setJavonetHandle(javonetHandle);
      javonetHandle.addEventListener(
          "AuthenticationPrompt",
          new com.javonet.api.INEventListener() {
            @Override
            public void eventOccurred(Object[] objects) {
              for (EventHandlerTEventArgs<AuthenticationPromptEventArgs> handler :
                  _AuthenticationPromptListeners) {
                handler.Invoke(
                    Convert(objects[0], Object.class),
                    Convert(objects[1], AuthenticationPromptEventArgs.class));
              }
            }
          });
    } catch (JavonetException _javonetException) {
      _javonetException.printStackTrace();
    }
  }

  public KeyboardInteractiveAuthenticationMethod(NObject handle) {
    super(handle);
    this.javonetHandle = handle;
  }

  public void setJavonetHandle(NObject handle) {
    this.javonetHandle = handle;
  }
  /** Method */

  public void Dispose() {
    try {
      javonetHandle.explicitInterface("jio.System.IDisposable").invoke("Dispose");
    } catch (JavonetException _javonetException) {
      _javonetException.printStackTrace();
    }
  }
  /** Method */

  public AuthenticationResult Authenticate(Session session) {
    try {
      Object res = javonetHandle.invoke("Authenticate", session);
      if (res == null) return null;
      return AuthenticationResult.valueOf(((NEnum) res).getValueName());
    } catch (JavonetException _javonetException) {
      _javonetException.printStackTrace();
      return null;
    }
  }
  /** Event */

  private java.util.ArrayList<EventHandlerTEventArgs<AuthenticationPromptEventArgs>>
      _AuthenticationPromptListeners =
          new java.util.ArrayList<EventHandlerTEventArgs<AuthenticationPromptEventArgs>>();

  public void addAuthenticationPrompt(EventHandlerTEventArgs<AuthenticationPromptEventArgs> toAdd) {
    _AuthenticationPromptListeners.add(toAdd);
  }

  public void removeAuthenticationPrompt(
      EventHandlerTEventArgs<AuthenticationPromptEventArgs> toRemove) {
    _AuthenticationPromptListeners.remove(toRemove);
  }

  static {
    try {
      Activation.initializeJavonet();
    } catch (java.lang.Exception e) {
      e.printStackTrace();
    }
  }
}
