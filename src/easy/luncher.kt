/**
     UniverseApplication                ------>  |                     LaunchActivity
attachBaseContext   ------> onCreate    ------>  |   init --------->      onCreate        ------>       onWindowFocusChanged
 * ^                         ^                   |     ^                    ^                                    ^
 * |                         |                   |     |                    |                                    |
 *A                               |----------Launch_Activity_Init-------|
 *B                                                     |-Launch_Activity_onCreate---|
 *c                                                                                  |---Launch_Activity_onShow---|
 *d |-------------------------                 Cold_Start_Up                                    ------------------|
 *e                       | ----AppUtilInit---------------------------AppColdLaunch----------  -------end-------  |
 */