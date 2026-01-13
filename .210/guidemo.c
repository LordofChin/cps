#include <objc/objc.h>
#include <objc/runtime.h>
#include <objc/message.h>
#include <Foundation/Foundation.h>
#import <AppKit/AppKit.h>

int main() {
    @autoreleasepool {
        Class NSApplicationClass = objc_getClass("NSApplication");
        Class NSWindowClass = objc_getClass("NSWindow");
        Class NSViewClass = objc_getClass("NSView");

        SEL allocSel = sel_registerName("alloc");
        SEL initSel = sel_registerName("init");

        // Create app
        id app = ((id (*)(Class, SEL))objc_msgSend)(NSApplicationClass, sel_registerName("sharedApplication"));

        // Create window
        NSRect frame = NSMakeRect(0, 0, 400, 300);
        id window = ((id (*)(Class, SEL))objc_msgSend)(NSWindowClass, allocSel);
        window = ((id (*)(id, SEL, NSRect, NSUInteger, NSInteger, BOOL))objc_msgSend)(
            window,
            sel_registerName("initWithContentRect:styleMask:backing:defer:"),
            frame,
            NSWindowStyleMaskTitled,
            NSBackingStoreBuffered,
            NO
        );

        // Create content view
        id view = ((id (*)(Class, SEL))objc_msgSend)(NSViewClass, allocSel);
        view = ((id (*)(id, SEL, NSRect))objc_msgSend)(view, sel_registerName("initWithFrame:"), frame);

        // Attach view
        ((void (*)(id, SEL, id))objc_msgSend)(window, sel_registerName("setContentView:"), view);

        // Show window
        ((void (*)(id, SEL, id))objc_msgSend)(window, sel_registerName("makeKeyAndOrderFront:"), nil);

        // Run app
        ((void (*)(id, SEL))objc_msgSend)(app, sel_registerName("run"));
    }
}

